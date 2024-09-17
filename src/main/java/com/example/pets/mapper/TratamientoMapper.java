package com.example.pets.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.entity.TratamientosEntity;

import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface TratamientoMapper {
    TratamientoMapper INSTANCE = Mappers.getMapper(TratamientoMapper.class);

    TratamientosEntity dtoToEntity(TratamientoPersistencia tratamientoPersistencia);
}
