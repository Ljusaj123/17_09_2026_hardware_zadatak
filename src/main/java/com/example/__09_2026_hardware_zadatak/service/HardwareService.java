package com.example.__09_2026_hardware_zadatak.service;

import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();

    HardwareDTO getHardwareByCode(String hardwareCode);

    void saveNewHardware(HardwareDTO hardwareDTO);

    void updateHardware(HardwareDTO hardwareDTO, Integer hardwareId);

    void deleteHardwareById(Integer hardwareId);
}
