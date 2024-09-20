package com.example.pets.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteTratamientosDTO {

    private LocalDateTime fechaInicio;
    private String descripcion;
    private String dosis;
    private String nombre;
}
