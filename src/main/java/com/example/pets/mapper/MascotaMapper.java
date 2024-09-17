package com.example.pets.mapper;

import com.example.pets.dto.MascotaConsulta;
import com.example.pets.dto.MascotaPersistencia;
import com.example.pets.dto.MascotaUpdate;
import com.example.pets.entity.MascotasEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MascotaMapper {

    MascotaMapper INSTANCE = Mappers.getMapper(MascotaMapper.class);

    MascotasEntity dtoToEntity(MascotaPersistencia mascotaPersistencia);

    List<MascotaConsulta> listEntityToListDto(List<MascotasEntity> entities);

    MascotasEntity dtoUpdateToEntity(MascotaUpdate mascota);
}
