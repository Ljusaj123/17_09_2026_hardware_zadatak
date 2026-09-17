package com.example.__09_2026_hardware_zadatak.service;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import com.example.__09_2026_hardware_zadatak.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService{

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream().map(this::convertHardwareToHardwareDTO).toList();
    }

    @Override
    public HardwareDTO getHardwareByCode(String hardwareCode) {
        Hardware hardware = hardwareRepository.getHardwareByCode(hardwareCode);

        return convertHardwareToHardwareDTO(hardware);

    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getNaziv(),
                hardware.getŠifra(), hardware.getCijena(),
                hardware.getTip().name(), hardware.getKolicina());
    }
}
