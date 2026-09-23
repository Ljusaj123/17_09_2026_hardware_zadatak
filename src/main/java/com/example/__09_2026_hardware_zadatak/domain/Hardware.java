package com.example.__09_2026_hardware_zadatak.domain;

import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
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
    private String sifra;
    private BigDecimal cijena;
    private Type tip;
    private int kolicina;

    public Hardware(HardwareDTO hardwareDTO) {
        this.naziv = hardwareDTO.getNaziv();
        this.sifra = hardwareDTO.getSifra();
        this.cijena = hardwareDTO.getCijena();
        this.tip = Type.valueOf(hardwareDTO.getTip());
        this.kolicina = hardwareDTO.getKolicina();
    }
}
