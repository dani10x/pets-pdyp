package com.example.pets.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Mensaje {

    private Boolean error;
    private String respuesta;
}
