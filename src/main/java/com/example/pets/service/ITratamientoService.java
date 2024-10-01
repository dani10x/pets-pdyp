package com.example.pets.service;

import java.util.List;

import com.example.pets.dto.*;
import com.example.pets.entity.TratamientosEntity;
import com.example.pets.exception.DataException;

public interface ITratamientoService {

    void CrearTratamiento(TratamientoPersistencia tratamiento) throws DataException;

    List<TratamientoConsulta> ListarTratamientos() throws DataException;

    void EleminarTratamiento(Integer id) throws DataException;

    void ActualizarTratamiento(TratamientoUpdate tratamiento) throws DataException;

    List<TratamientoMascotaConsulta> ListarTratamientos(Integer id) throws DataException;

    List<ReporteTratamientosDTO> reporteTratamientos(Integer id);

    List<TratamientosEntity> getAllEntities();
}
    