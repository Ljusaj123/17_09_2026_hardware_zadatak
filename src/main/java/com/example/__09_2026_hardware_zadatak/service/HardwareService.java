package com.example.__09_2026_hardware_zadatak.service;

import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    HardwareDTO getHardwareByCode(String hardwareCode);
}
