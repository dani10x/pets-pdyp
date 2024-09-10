package com.example.pets.service;

import com.example.pets.dto.MascotaPersistencia;
import com.example.pets.exception.DataException;

public interface IMascotaService {
    void CrearMascotas(MascotaPersistencia mascota) throws DataException;
}
