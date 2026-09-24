package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.domain.Type;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockHardwareRepository implements HardwareRepository {
    private static final List<Hardware> hardwareList;

    static {
        hardwareList = new ArrayList<>();

        Hardware firstHardware = new Hardware(1L, "Intel Core i7-14700K", "CPU-001", new BigDecimal("429.99"), Type.CPU, 10);

        Hardware secondHardware = new Hardware(2L, "NVIDIA GeForce RTX 4070", "GPU-001", new BigDecimal("599.99"), Type.GPU, 15);

        Hardware thirdHardware = new Hardware(3L, "ASUS ROG STRIX B650", "MBO-001", new BigDecimal("249.99"), Type.MBO, 2);

        Hardware fourthHardware = new Hardware(4L, "Corsair Vengeance 32GB", "RAM-001", new BigDecimal("89.99"), Type.RAM, 30);

        hardwareList.add(firstHardware);
        hardwareList.add(secondHardware);
        hardwareList.add(thirdHardware);
        hardwareList.add(fourthHardware);
    }

    @Override
    public List<Hardware> getAllHardware() {
        return hardwareList;
    }

    @Override
    public Optional<Hardware> getHardwareByCode(String hardwareCode) {
        return hardwareList.stream()
                .filter(a -> a.getSifra().equalsIgnoreCase(hardwareCode))
                .findFirst();
    }

    @Override
    public void saveNewHardware(Hardware hardware) {
        hardware.setId((long) (hardwareList.size() + 1));
        hardwareList.add(hardware);
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardware, Integer hardwareId) {

        Optional<Hardware> storedHardwareOptional = hardwareList.stream()
                .filter(h -> h.getId().equals(hardwareId))
                .findFirst();

        if (storedHardwareOptional.isEmpty()) {
            return Optional.empty();
        }

        Hardware storedHardware = storedHardwareOptional.get();

        storedHardware.setNaziv(hardware.getNaziv());
        storedHardware.setTip(hardware.getTip());
        storedHardware.setSifra(hardware.getSifra());
        storedHardware.setCijena(hardware.getCijena());
        storedHardware.setKolicina(hardware.getKolicina());

        return Optional.of(storedHardware);
    }

    @Override
    public boolean deleteHardware(Integer hardwareId) {
        return hardwareList.removeIf(
                hardware -> hardware.getId().equals(hardwareId)
        );
    }

    @Override
    public boolean hardwareByIdExists(Integer id) {
        return false;
    }
}
