package com.example.__09_2026_hardware_zadatak.dto;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    @NotBlank(message = "Naziv je obavezan")
    private String naziv;

    @NotBlank(message = "Šifra je obavezna")
    private String sifra;

    @NotNull(message = "Cijena je obavezna")
    @Positive(message = "Cijena mora biti veća od 0")
    private BigDecimal cijena;

    @NotNull(message = "Tip je obavezan")
    private String tip;

    @NotNull(message = "Količina je obavezna")
    @Positive(message = "Količina ne može biti negativna")
    private int kolicina;

    public HardwareDTO(Hardware hardware) {
        this.naziv = hardware.getNaziv();
        this.sifra = hardware.getSifra();
        this.cijena = hardware.getCijena();
        this.tip = String.valueOf(hardware.getTip());
        this.kolicina = hardware.getKolicina();
    }
}
