package com.example.pets.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.example.pets.dto.MedicamentoConsulta;
import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.dto.MedicamentoUpdate;
import com.example.pets.entity.MedicamentosEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicamentoMapper {

    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    MedicamentosEntity dtoToEntity(MedicamentoPersistencia medicamentoPersistencia);

    List<MedicamentoConsulta> listEntityToListDto(List<MedicamentosEntity> entities);

    MedicamentosEntity dtoUpdateToEntity(MedicamentoUpdate medicamento);
}
