package com.example.pets.mapper;

import com.example.pets.dto.ClienteAutocompletable;
import com.example.pets.dto.ClienteConsulta;
import com.example.pets.dto.ClientePersistencia;
import com.example.pets.dto.ClienteUpdate;
import com.example.pets.entity.ClientesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClientesEntity dtoToEntity(ClientePersistencia clientePersistencia);

    ClienteConsulta entityToDto(ClientesEntity entity);

    List<ClienteConsulta> listEntityToListDto(List<ClientesEntity> entities);

    ClientesEntity dtoUpdateToEntity(ClienteUpdate cliente);

}
