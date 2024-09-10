package com.example.pets.service.impl;

import com.example.pets.dto.ClientePersistencia;
import com.example.pets.entity.ClientesEntity;
import com.example.pets.exception.DataException;
import com.example.pets.repository.ClientesRepository;
import com.example.pets.service.IClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClientesService {

    private final ClientesRepository clientesRepository;

    @Override
    public void crearCliente(ClientePersistencia cliente) throws DataException {
        if(clientesRepository.existsByCedula(cliente.getCedula())) {
            throw new DataException("El cliente con cedula {0} ya existe", cliente.getCedula());
        }
        ClientesEntity entity = new ClientesEntity();
        entity.setNombres(cliente.getNombres());
        entity.setApellidos(cliente.getApellidos());
        entity.setCedula(cliente.getCedula());
        entity.setDireccion(cliente.getDireccion());
        entity.setTelefono(cliente.getTelefonos());
        clientesRepository.save(entity);
    }


}
