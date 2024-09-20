package com.example.pets.mapper;
import java.util.List;

import com.example.pets.dto.TratamientoMascotaConsulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.pets.dto.TratamientoConsulta;
import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.dto.TratamientoUpdate;
import com.example.pets.entity.TratamientosEntity;

import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface TratamientoMapper {

    TratamientoMapper INSTANCE = Mappers.getMapper(TratamientoMapper.class);

    TratamientosEntity dtoToEntity(TratamientoPersistencia tratamientoPersistencia);
    

    @Mapping(source = "medicamentosEntity.nombre", target = "nombreMedicamento")
    @Mapping(source = "mascotasEntity.nombre", target = "nombreMascota")
    TratamientoConsulta entityToDto(TratamientosEntity entity);
    List<TratamientoConsulta> listEntityToListDto(List<TratamientosEntity> entities);

    TratamientosEntity dtoUpdateToEntity(TratamientoUpdate tratamiento);

    @Mapping(source = "medicamentosEntity.nombre", target = "nombreMedicamento")
    @Mapping(source = "medicamentosEntity.dosis", target = "dosis")
    TratamientoMascotaConsulta entityToDtoTratamiento(TratamientosEntity entity);

    List<TratamientoMascotaConsulta> listEntityToListDtoTratamiento(List<TratamientosEntity> entities);

}
