package com.example.__09_2026_hardware_zadatak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    private String naziv;
    private String šifra;
    private BigDecimal cijena;
    private String tip;
    private int kolicina;
}
