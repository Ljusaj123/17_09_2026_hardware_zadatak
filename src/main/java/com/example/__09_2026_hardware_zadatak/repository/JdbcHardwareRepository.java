package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.domain.Type;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
@AllArgsConstructor
public class JdbcHardwareRepository implements HardwareRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Hardware> getAllHardware() {
        return jdbcTemplate.query("SELECT * FROM Hardware", new HardwareMapper());
    }

    @Override
    public Optional<Hardware> getHardwareByCode(String hardwareCode) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("sifra", hardwareCode);

        return jdbcTemplate.query("SELECT * FROM Hardware WHERE sifra = :sifra", parameters, new HardwareMapper()).stream().findFirst();
    }

    @Override
    public void saveNewHardware(Hardware hardware) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("naziv", hardware.getNaziv());
        parameters.put("sifra", hardware.getSifra());
        parameters.put("cijena", hardware.getCijena());
        parameters.put("tip", hardware.getTip().name());
        parameters.put("kolicina", hardware.getKolicina());

        final String SQL =
                "SELECT ID FROM FINAL TABLE (INSERT INTO Hardware (naziv, sifra, cijena, tip, kolicina) VALUES (:naziv, :sifra, :cijena, :tip, :kolicina)) Hardware";
        Long generatedId = jdbcTemplate.queryForObject(SQL, parameters, Long.class);
        hardware.setId(generatedId);

    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardware, Integer hardwareId) {
        if (!hardwareByIdExists(hardwareId)) return Optional.empty();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("naziv", hardware.getNaziv());
        parameters.put("sifra", hardware.getSifra());
        parameters.put("cijena", hardware.getCijena());
        parameters.put("tip", hardware.getTip().name());
        parameters.put("kolicina", hardware.getKolicina());
        parameters.put("id", hardwareId);

        final String SQL =
                "UPDATE Hardware SET naziv = :naziv, sifra = :sifra, cijena = :cijena, tip = :tip, kolicina = :kolicina WHERE id = :id";
        jdbcTemplate.update(SQL, parameters);
        hardware.setId(Long.valueOf(hardwareId));
        return Optional.of(hardware);
    }

    @Override
    public boolean deleteHardware(Integer hardwareId) {

        if (!hardwareByIdExists(hardwareId)) return false;

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", hardwareId);

        jdbcTemplate.update(
                "DELETE FROM Hardware WHERE id = :id",
                parameters
        );

        return true;
    }

    @Override
    public boolean hardwareByIdExists(Integer id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Hardware WHERE id = :id",
                parameters,
                Integer.class
        );
        return count != null && count != 0;
    }


    private static class HardwareMapper implements RowMapper<Hardware> {

        public Hardware mapRow(ResultSet rs, int i) throws SQLException {

            Hardware newHardware = new Hardware();
            newHardware.setId(rs.getLong("id"));
            newHardware.setNaziv(rs.getString("naziv"));
            newHardware.setSifra(rs.getString("sifra"));
            newHardware.setCijena(rs.getBigDecimal("cijena"));
            newHardware.setTip(Type.valueOf(rs.getString("tip")));

            return newHardware;
        }
    }
}
