package com.example.pets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteMascotasDTO {

    private String nombre;
    private String raza;
    private Float peso;
    private LocalDateTime fechaNacimiento;
    private List<ReporteTratamientosDTO> tratamientos;
}
