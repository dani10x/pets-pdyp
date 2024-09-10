package com.example.pets.service.impl;

import com.example.pets.mapper.MascotaMapper;
import org.springframework.stereotype.Service;

import com.example.pets.dto.MascotaPersistencia;
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
}
