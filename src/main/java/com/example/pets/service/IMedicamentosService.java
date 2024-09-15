package com.example.pets.service;

import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.exception.DataException;

public interface IMedicamentosService {

    void CrearMedicamento(MedicamentoPersistencia medicametos) throws DataException;
    void EliminarMedicamento(Integer id) throws DataException;
}
