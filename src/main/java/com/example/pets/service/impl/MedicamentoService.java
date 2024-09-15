package com.example.pets.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pets.dto.MedicamentoConsulta;
import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.dto.MedicamentoUpdate;
import com.example.pets.entity.MedicamentosEntity;
import com.example.pets.exception.DataException;
import com.example.pets.mapper.MedicamentoMapper;
import com.example.pets.repository.MedicamentosRepository;
import com.example.pets.service.IMedicamentosService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentoService implements IMedicamentosService {
    private final MedicamentosRepository medicamentoRepository;

    @Override
    public void CrearMedicamento(MedicamentoPersistencia medicamento) throws DataException {
        MedicamentosEntity entity = MedicamentoMapper.INSTANCE.dtoToEntity(medicamento);
        medicamentoRepository.save(entity);
    }

    @Override
    public void EliminarMedicamento(Integer id) throws DataException{
        if (medicamentoRepository.existsById(id)) {
            medicamentoRepository.deleteById(id);
        } else {
            throw new DataException("El medicamento que intento eliminar no exite ");
        }
    }

    @Override
    public List<MedicamentoConsulta> listarMedicamentos() throws DataException{
        return Optional.of(medicamentoRepository.findAll())
                .filter(c -> !c.isEmpty())
                .map(MedicamentoMapper.INSTANCE::listEntityToListDto)
                .orElseThrow(() -> new DataException("No existe ningún medicamento registrado"));
    }

    @Override
    public void ActualizarMedicamento(MedicamentoUpdate medicamento) throws DataException{
        if(medicamentoRepository.existsById((medicamento.getId()))){
            medicamentoRepository.save(MedicamentoMapper.INSTANCE.dtoUpdateToEntity(medicamento));
        }else {
            throw new DataException("El medicamento que intento actualizar no existe");
        }
    }
}
