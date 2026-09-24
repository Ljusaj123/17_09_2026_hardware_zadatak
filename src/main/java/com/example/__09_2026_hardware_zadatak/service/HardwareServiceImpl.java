package com.example.__09_2026_hardware_zadatak.service;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import com.example.__09_2026_hardware_zadatak.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream().map(HardwareDTO::new).toList();
    }

    @Override
    public HardwareDTO getHardwareByCode(String hardwareCode) {
        Hardware hardware = hardwareRepository.getHardwareByCode(hardwareCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware ne postoji"));
        return new HardwareDTO(hardware);
    }

    @Override
    public void saveNewHardware(HardwareDTO hardwareDTO) {
        Hardware hardware = new Hardware(hardwareDTO);

        hardwareRepository.saveNewHardware(hardware);
    }

    @Override
    public void updateHardware(HardwareDTO hardwareDTO, Integer hardwareId) {

        Hardware hardware = new Hardware(hardwareDTO);

        Optional<Hardware> updatedHardware =
                hardwareRepository.updateHardware(hardware, hardwareId);

        if (updatedHardware.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Hardware sa ID-em " + hardwareId + " ne postoji"
            );
        }
    }

    @Override
    public void deleteHardwareById(Integer hardwareId) {
        boolean deleted = hardwareRepository.deleteHardware(hardwareId);

        if (!deleted) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Hardware sa ID-em " + hardwareId + " ne postoji"
            );
        }
    }
}
