package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Hardware;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface SpringDataHardwareRepository extends JpaRepository<Hardware, Integer> {
    Hardware findBySifra(String name);
}
