package com.example.pets.mapper;

import com.example.pets.dto.ClientePersistencia;
import com.example.pets.entity.ClientesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClientesEntity dtoToEntity(ClientePersistencia clientePersistencia);
}
