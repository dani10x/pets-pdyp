package com.example.pets.service.impl;

import org.springframework.stereotype.Service;

import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.entity.MascotasEntity;
import com.example.pets.entity.MedicamentosEntity;
import com.example.pets.entity.TratamientosEntity;
import com.example.pets.exception.DataException;
import com.example.pets.mapper.TratamientoMapper;
import com.example.pets.repository.MascotasRepository;
import com.example.pets.repository.MedicamentosRepository;
import com.example.pets.repository.TratamientoRepository;
import com.example.pets.service.ITratamientoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TratamientoService implements ITratamientoService{

    private final TratamientoRepository tratamientoRepository;

    public void CrearTratamiento(TratamientoPersistencia tratamiento) throws DataException{
        TratamientosEntity entity=TratamientoMapper.INSTANCE.dtoToEntity(tratamiento);
        tratamientoRepository.save(entity);

    }
}
