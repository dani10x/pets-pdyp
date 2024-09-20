package com.example.pets.service;

import java.util.List;
import com.example.pets.dto.TratamientoConsulta;
import com.example.pets.dto.TratamientoMascotaConsulta;
import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.dto.TratamientoUpdate;
import com.example.pets.exception.DataException;

public interface ITratamientoService {

    void CrearTratamiento(TratamientoPersistencia tratamiento) throws DataException;

    List<TratamientoConsulta> ListarTratamientos() throws DataException;

    void EleminarTratamiento(Integer id) throws DataException;

    void ActualizarTratamiento(TratamientoUpdate tratamiento) throws DataException;

    List<TratamientoMascotaConsulta> ListarTratamientos(Integer id) throws DataException;
}
    