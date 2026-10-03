package com.example.__09_2026_hardware_zadatak.domain;

import com.example.__09_2026_hardware_zadatak.dto.HardwareDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hardware")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String sifra;
    private BigDecimal cijena;
    private Integer kolicina;

    @ManyToOne
    @JoinColumn(name = "tip_id")
    private Type tip;

    public Hardware(HardwareDTO hardwareDTO) {
        this.naziv = hardwareDTO.getNaziv();
        this.sifra = hardwareDTO.getSifra();
        this.cijena = hardwareDTO.getCijena();
        this.tip = hardwareDTO.getTip();
        this.kolicina = hardwareDTO.getKolicina();
    }
}
