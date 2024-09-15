package com.example.pets.service;

import com.example.pets.dto.ClienteConsulta;
import com.example.pets.dto.ClientePersistencia;
import com.example.pets.dto.ClienteUpdate;
import com.example.pets.exception.DataException;

import java.util.List;

public interface IClientesService {

    void crearCliente(ClientePersistencia cliente) throws DataException;

    void eliminarCliente(Integer idCliente) throws DataException;

    List<ClienteConsulta> listarClientes() throws DataException;

    void actualizarCliente(ClienteUpdate cliente) throws DataException;

}
