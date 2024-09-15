package com.example.pets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoUpdate {
    @NotNull
    private Integer id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String dosis;
}
