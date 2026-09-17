package com.example.__09_2026_hardware_zadatak.controller;

import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import com.example.__09_2026_hardware_zadatak.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware().stream().toList();
    }

    @GetMapping("/{hardwareCode}")
    public HardwareDTO getHardwareByCode(@PathVariable String hardwareCode) {
        return hardwareService.getHardwareByCode(hardwareCode);
    }
}
