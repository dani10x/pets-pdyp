package com.example.pets.service;

import java.util.List;

import com.example.pets.dto.MedicamentoConsulta;
import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.dto.MedicamentoUpdate;
import com.example.pets.exception.DataException;

public interface IMedicamentosService {

    void CrearMedicamento(MedicamentoPersistencia medicametos) throws DataException;

    void EliminarMedicamento(Integer id) throws DataException;

    List<MedicamentoConsulta> listarMedicamentos() throws DataException;
    
    void ActualizarMedicamento(MedicamentoUpdate medicamento) throws DataException;
}
