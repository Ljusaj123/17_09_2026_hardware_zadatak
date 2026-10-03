package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.domain.Type;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcHardwareRepository implements HardwareRepository {
    @Override
    public List<Hardware> getAllHardware() {
        return List.of();
    }

    @Override
    public Optional<Hardware> getHardwareByCode(String hardwareCode) {
        return Optional.empty();
    }

    @Override
    public void saveNewHardware(Hardware hardware) {

    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardware, Integer hardwareId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteHardware(Integer hardwareId) {
        return false;
    }

    @Override
    public boolean hardwareByIdExists(Integer id) {
        return false;
    }
//
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Hardware> getAllHardware() {
//        return jdbcTemplate.query("SELECT * FROM Hardware", new HardwareMapper());
//    }
//
//    @Override
//    public Optional<Hardware> getHardwareByCode(String hardwareCode) {
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("sifra", hardwareCode);
//
//        return jdbcTemplate.query("SELECT * FROM Hardware WHERE sifra = :sifra", parameters, new HardwareMapper()).stream().findFirst();
//    }
//
//    @Override
//    public void saveNewHardware(Hardware hardware) {
////        Map<String, Object> parameters = new HashMap<>();
////        parameters.put("naziv", hardware.getNaziv());
////        parameters.put("sifra", hardware.getSifra());
////        parameters.put("cijena", hardware.getCijena());
////        parameters.put("tip", hardware.getTip().name());
////        parameters.put("kolicina", hardware.getKolicina());
////
////        final String SQL =
////                "SELECT ID FROM FINAL TABLE (INSERT INTO Hardware (naziv, sifra, cijena, tip, kolicina) VALUES (:naziv, :sifra, :cijena, :tip, :kolicina)) Hardware";
////        Long generatedId = jdbcTemplate.queryForObject(SQL, parameters, Long.class);
////        hardware.setId(generatedId);
//
//
//
//        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate.getJdbcTemplate())
//                .withTableName("Hardware")
//                .usingGeneratedKeyColumns("ID");
//
//        Map<String, Object> parameters = Map.of(
//                "naziv", hardware.getNaziv(),
//                "sifra", hardware.getSifra(),
//                "cijena", hardware.getCijena(),
//                "tip_id", hardware.getTip().getId(),
//                "kolicina", hardware.getKolicina()
//        );
//
//        Number generatedId = insert.executeAndReturnKey(parameters);
//        hardware.setId((long) generatedId.intValue());
//
//    }
//
//    @Override
//    public Optional<Hardware> updateHardware(Hardware hardware, Integer hardwareId) {
//        if (!hardwareByIdExists(hardwareId)) return Optional.empty();
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("naziv", hardware.getNaziv());
//        parameters.put("sifra", hardware.getSifra());
//        parameters.put("cijena", hardware.getCijena());
//        parameters.put("tip_id", hardware.getTip().getId());
//        parameters.put("kolicina", hardware.getKolicina());
//        parameters.put("id", hardwareId);
//
//        final String SQL =
//                "UPDATE Hardware SET naziv = :naziv, sifra = :sifra, cijena = :cijena, tip_id = :tip_id, kolicina = :kolicina WHERE id = :id";
//        jdbcTemplate.update(SQL, parameters);
//        hardware.setId(Long.valueOf(hardwareId));
//        return Optional.of(hardware);
//    }
//
//    @Override
//    public boolean deleteHardware(Integer hardwareId) {
//
//        if (!hardwareByIdExists(hardwareId)) return false;
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("id", hardwareId);
//
//        jdbcTemplate.update(
//                "DELETE FROM Hardware WHERE id = :id",
//                parameters
//        );
//
//        return true;
//    }
//
//    @Override
//    public boolean hardwareByIdExists(Integer id) {
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("id", id);
//
//        Integer count = jdbcTemplate.queryForObject(
//                "SELECT COUNT(*) FROM Hardware WHERE id = :id",
//                parameters,
//                Integer.class
//        );
//        return count != null && count != 0;
//    }
//
//
//    private static class HardwareMapper implements RowMapper<Hardware> {
//
//        public Hardware mapRow(ResultSet rs, int i) throws SQLException {
//
//            Hardware newHardware = new Hardware();
//            newHardware.setId(rs.getLong("id"));
//            newHardware.setNaziv(rs.getString("naziv"));
//            newHardware.setSifra(rs.getString("sifra"));
//            newHardware.setCijena(rs.getBigDecimal("cijena"));
//            newHardware.setKolicina(rs.getInt("kolicina"));
//
//            Integer typeId = rs.getInt("tip_id");
//            if (Type.CPU.getId().equals(typeId)) {
//                newHardware.setTip(Type.CPU);
//            }
//            else if (Type.GPU.getId().equals(typeId)) {
//                newHardware.setTip(Type.GPU);
//            }
//            else if (Type.MBO.getId().equals(typeId)) {
//                newHardware.setTip(Type.MBO);
//            }
//            else if (Type.RAM.getId().equals(typeId)) {
//                newHardware.setTip(Type.RAM);
//            }
//            else if (Type.STORAGE.getId().equals(typeId)) {
//                newHardware.setTip(Type.STORAGE);
//            }
//            else if (Type.OTHER.getId().equals(typeId)) {
//                newHardware.setTip(Type.OTHER);
//            }
//
//            return newHardware;
//        }
//    }
}
