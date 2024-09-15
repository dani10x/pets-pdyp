package com.example.pets.service;

import java.util.List;

import com.example.pets.dto.MascotaConsulta;
import com.example.pets.dto.MascotaPersistencia;
import com.example.pets.dto.MascotaUpdate;
import com.example.pets.exception.DataException;

public interface IMascotaService {
    void CrearMascotas(MascotaPersistencia mascota) throws DataException;

    void EliminarMascota(Integer Id) throws DataException;

    List<MascotaConsulta> ListarMascotas() throws DataException;

    void ActualizarMascota(MascotaUpdate mascosta) throws DataException;
}
