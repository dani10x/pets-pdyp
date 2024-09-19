package com.example.pets.service.impl;

import com.example.pets.dto.ClienteAutocompletable;
import com.example.pets.dto.ClienteConsulta;
import com.example.pets.dto.ClientePersistencia;
import com.example.pets.dto.ClienteUpdate;
import com.example.pets.entity.ClientesEntity;
import com.example.pets.exception.DataException;
import com.example.pets.mapper.ClienteMapper;
import com.example.pets.repository.ClientesRepository;
import com.example.pets.service.IClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClientesService {

    private final ClientesRepository clientesRepository;

    @Override
    public void crearCliente(ClientePersistencia cliente) throws DataException {
        if(clientesRepository.existsByCedula(cliente.getCedula())) {
            throw new DataException("El cliente con cedula {0} ya existe", cliente.getCedula());
        }
        ClientesEntity entity = ClienteMapper.INSTANCE.dtoToEntity(cliente);
        clientesRepository.save(entity);
    }

    @Override
    public void eliminarCliente(Integer idCliente) throws DataException {
        if(!clientesRepository.existsById(idCliente)) {
            throw new DataException("El cliente que se intentó eliminar no existe");
        }
        clientesRepository.deleteById(idCliente);
    }

    @Override
    public List<ClienteConsulta> listarClientes() throws DataException {
        return Optional.of(clientesRepository.findAll())
                .filter(c -> !c.isEmpty())
                .map(ClienteMapper.INSTANCE::listEntityToListDto)
                .orElseThrow(() -> new DataException("No existe ningún cliente registrado"));
    }

    @Override
    public void actualizarCliente(ClienteUpdate cliente) throws DataException {
        if(!clientesRepository.existsById(cliente.getId())) {
            throw new DataException("El cliente que se intentó actualizar no existe");
        }
        clientesRepository.save(ClienteMapper.INSTANCE.dtoUpdateToEntity(cliente));
    }

    @Override
    public List<ClienteAutocompletable> consultarClientesAutocomplete() throws DataException {
        return clientesRepository.findAutocompletable();
    }
}
