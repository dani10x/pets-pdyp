package com.example.pets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientePersistencia {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefonos;
}
