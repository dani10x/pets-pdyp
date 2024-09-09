package com.example.pets.service;

import com.example.pets.dto.ClientePersistencia;
import com.example.pets.exception.DataException;

public interface IClientesService {

    void crearCliente(ClientePersistencia cliente) throws DataException;
}
