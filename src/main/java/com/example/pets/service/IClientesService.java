package com.example.pets.service;

import com.example.pets.dto.*;
import com.example.pets.exception.DataException;

import java.util.List;

public interface IClientesService {

    void crearCliente(ClientePersistencia cliente) throws DataException;

    void eliminarCliente(Integer idCliente) throws DataException;

    List<ClienteConsulta> listarClientes() throws DataException;

    void actualizarCliente(ClienteUpdate cliente) throws DataException;

    List<ClienteAutocompletable> consultarClientesAutocomplete() throws DataException;

    ReporteClientesDTO consultarReporteCliente(Integer idCliente) throws DataException;

}
