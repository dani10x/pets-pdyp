package com.example.pets.service.impl;

import org.springframework.stereotype.Service;

import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.entity.MedicamentosEntity;
import com.example.pets.exception.DataException;
import com.example.pets.mapper.MedicamentoMapper;
import com.example.pets.repository.MedicamentosRepository;
import com.example.pets.service.IMedicamentosService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentoService implements IMedicamentosService {
    private final MedicamentosRepository medicamentoRepository;

    @Override
    public void CrearMedicamento(MedicamentoPersistencia medicamento) throws DataException {
        MedicamentosEntity entity = MedicamentoMapper.INSTANCE.dtoToEntity(medicamento);
        medicamentoRepository.save(entity);
    }

    @Override
    public void EliminarMedicamento(Integer id) {
        if (medicamentoRepository.existsById(id)) {
            medicamentoRepository.deleteById(id);
        } else {
            throw new DataException("Medicamento {0} no exite ", id);
        }
    }
}
