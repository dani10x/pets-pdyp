package com.example.pets.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pets.dto.TratamientoConsulta;
import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.dto.TratamientoUpdate;
import com.example.pets.entity.TratamientosEntity;
import com.example.pets.exception.DataException;
import com.example.pets.mapper.TratamientoMapper;
import com.example.pets.repository.TratamientoRepository;
import com.example.pets.service.ITratamientoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TratamientoService implements ITratamientoService{

    private final TratamientoRepository tratamientoRepository;

    @Override
    public void CrearTratamiento(TratamientoPersistencia tratamiento) throws DataException{
        TratamientosEntity entity=TratamientoMapper.INSTANCE.dtoToEntity(tratamiento);
        tratamientoRepository.save(entity);

    }

    @Override
    public List<TratamientoConsulta> ListarTratamientos() throws DataException{
        return Optional.of(tratamientoRepository.findAll())
                .filter(c -> !c.isEmpty())
                .map(TratamientoMapper.INSTANCE::listEntityToListDto)
                .orElseThrow(() -> new DataException("No existe ningun tratamiento registrado"));
    }

    @Override
    public void EleminarTratamiento(Integer id) throws DataException{
        if (tratamientoRepository.existsById(id)) {
            tratamientoRepository.deleteById(id);
        }else{
            throw new DataException("Tratamiento que intento eliminar no existe");
        }
    }

    @Override
    public void ActualizarTratamiento(TratamientoUpdate tratamiento)throws DataException{
        if (tratamientoRepository.existsById(tratamiento.getId())) {
            tratamientoRepository.save(TratamientoMapper.INSTANCE.dtoUpdateToEntity(tratamiento));

        }else{
            throw new DataException("el tratamiento que intento actualizar no existe");
        }
    }

}
