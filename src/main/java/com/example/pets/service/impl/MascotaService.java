package com.example.pets.service.impl;

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
        MascotasEntity entity=new MascotasEntity();
        entity.setNombre(mascota.getNombre());
        entity.setRaza(mascota.getRaza());
        entity.setPeso(mascota.getPeso());
        entity.setFechaNacimiento(mascota.getFechaNacimiento());
        mascotaRepository.save(entity);
    }
}
