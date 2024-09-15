package com.example.pets.service.impl;


import com.example.pets.mapper.MascotaMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.pets.dto.MascotaConsulta;
import com.example.pets.dto.MascotaPersistencia;
import com.example.pets.dto.MascotaUpdate;
import com.example.pets.entity.MascotasEntity;
import com.example.pets.exception.DataException;
import com.example.pets.repository.MascotasRepository;
import com.example.pets.service.IMascotaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MascotaService implements IMascotaService {

    private final MascotasRepository mascotaRepository;

    @Override
    public void CrearMascotas(MascotaPersistencia mascota) throws DataException{
        MascotasEntity entity= MascotaMapper.INSTANCE.dtoToEntity(mascota);
        mascotaRepository.save(entity);
    }

    @Override
    public void EliminarMascota(Integer Id) throws DataException{
        if(mascotaRepository.existsById(Id)){
            mascotaRepository.deleteById(Id);
        }else{
            throw new DataException("Mascota que intento eliminar no existe");
        }
    }

    @Override
    public List<MascotaConsulta> ListarMascotas() throws DataException{
        return Optional.of(mascotaRepository.findAll())
                .filter(c -> !c.isEmpty())
                .map(MascotaMapper.INSTANCE::listEntityToListDto)
                .orElseThrow(() -> new DataException("No existe ninguna mascota registrada"));
    }

    @Override
    public void ActualizarMascota(MascotaUpdate mascota) throws DataException{
        if(mascotaRepository.existsById(mascota.getId())){
            mascotaRepository.save(MascotaMapper.INSTANCE.dtoUpdateToEntity(mascota));
        }else{
            throw new DataException("La mascota que intento actualizar no existe");
        }
    }
}
