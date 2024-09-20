package com.example.pets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TratamientoMascotaConsulta {
    private Integer id;
    private String dosis;
    private LocalDateTime fechaInicio;
    private String nombreMedicamento;
}
