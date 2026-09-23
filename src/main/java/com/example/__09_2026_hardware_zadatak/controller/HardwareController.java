package com.example.__09_2026_hardware_zadatak.controller;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import com.example.__09_2026_hardware_zadatak.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping()
    public ResponseEntity<String> saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        hardwareService.saveNewHardware(hardwareDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Hardware je uspješno kreiran");
    }

    @PutMapping("/{hardwareId}")
    public ResponseEntity<String> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable Integer hardwareId) {
        hardwareService.updateHardware(hardwareDTO, hardwareId);

        return ResponseEntity.ok("Hardware je uspješno ažuriran");
    }

    @DeleteMapping("/{hardwareId}")
    public ResponseEntity<String> deleteHardwareById(@PathVariable Integer hardwareId) {
        hardwareService.deleteHardwareById(hardwareId);

        return ResponseEntity.ok("Hardware je uspješno obrisan");
    }

}
