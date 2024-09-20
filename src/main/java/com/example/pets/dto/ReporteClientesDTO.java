package com.example.pets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteClientesDTO {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private List<ReporteMascotasDTO> mascotas;
}
