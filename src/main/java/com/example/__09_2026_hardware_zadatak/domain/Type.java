package com.example.__09_2026_hardware_zadatak.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    CPU(1),
    GPU(2),
    MBO(3),
    RAM(4),
    STORAGE(5),
    OTHER(6);

    private final Integer id;
}