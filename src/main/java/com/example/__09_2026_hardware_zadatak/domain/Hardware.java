package com.example.__09_2026_hardware_zadatak.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    private Integer id;
    private String naziv;
    private String šifra;
    private BigDecimal cijena;
    private Type tip;
    private int kolicina;
}
