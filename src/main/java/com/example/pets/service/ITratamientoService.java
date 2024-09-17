package com.example.pets.service;

import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.exception.DataException;

public interface ITratamientoService {

    void CrearTratamiento(TratamientoPersistencia tratamiento) throws DataException;

}
    