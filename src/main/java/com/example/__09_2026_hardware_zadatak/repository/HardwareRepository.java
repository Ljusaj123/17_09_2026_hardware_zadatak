package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> getAllHardware();

    Hardware getHardwareByCode(String hardwareCode);

    void saveNewHardware(Hardware hardware);

    Optional<Hardware> updateHardware(Hardware hardware, Integer hardwareId);

    boolean deleteHardware(Integer hardwareId);
}
