package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    Hardware getHardwareByCode(String hardwareCode);
}
