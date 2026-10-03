package com.example.__09_2026_hardware_zadatak.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Type")
public class Type{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
}

//@Getter
//@AllArgsConstructor
//public enum Type {
//    CPU(1),
//    GPU(2),
//    MBO(3),
//    RAM(4),
//    STORAGE(5),
//    OTHER(6);
//
//    private final Integer id;
//}