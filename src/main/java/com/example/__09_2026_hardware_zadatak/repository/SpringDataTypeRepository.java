package com.example.__09_2026_hardware_zadatak.repository;

import com.example.__09_2026_hardware_zadatak.domain.Type;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface SpringDataTypeRepository extends JpaRepository<Type, Integer> {
    Type findByNaziv(String name);
}
