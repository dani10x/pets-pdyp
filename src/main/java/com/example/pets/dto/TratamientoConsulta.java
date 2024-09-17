package com.example.pets.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TratamientoConsulta {
    private LocalDateTime fechaInicio;
    private String nombreMedicamento;
    private String nombreMascota;
}
