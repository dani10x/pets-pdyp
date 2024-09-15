package com.example.pets.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.entity.MedicamentosEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicamentoMapper {

    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    MedicamentosEntity dtoToEntity(MedicamentoPersistencia medicamentoPersistencia);
}
