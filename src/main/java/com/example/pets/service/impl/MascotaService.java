package com.example.pets.service.impl;


import com.example.pets.dto.*;
import com.example.pets.mapper.MascotaMapper;
import java.util.List;
import java.util.Optional;

import com.example.pets.service.ITratamientoService;
import org.springframework.stereotype.Service;
import com.example.pets.entity.MascotasEntity;
import com.example.pets.exception.DataException;
import com.example.pets.repository.MascotasRepository;
import com.example.pets.service.IMascotaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MascotaService implements IMascotaService {

    private final MascotasRepository mascotaRepository;
    private final ITratamientoService tratamientoService;

    @Override
    public void CrearMascotas(MascotaPersistencia mascota) throws DataException{
        MascotasEntity entity= MascotaMapper.INSTANCE.dtoToEntity(mascota);
        mascotaRepository.save(entity);
    }

    @Override
    public void EliminarMascota(Integer Id) throws DataException{
        if(mascotaRepository.existsById(Id)){
            mascotaRepository.deleteById(Id);
        }else{
            throw new DataException("Mascota que intento eliminar no existe");
        }
    }

    @Override
    public List<MascotaConsulta> ListarMascotas() throws DataException{
        return Optional.of(mascotaRepository.findAll())
                .filter(c -> !c.isEmpty())
                .map(MascotaMapper.INSTANCE::listEntityToListDto)
                .orElseThrow(() -> new DataException("No existe ninguna mascota registrada"));
    }

    @Override
    public void ActualizarMascota(MascotaUpdate mascota) throws DataException{
        if(mascotaRepository.existsById(mascota.getId())){
            mascotaRepository.save(MascotaMapper.INSTANCE.dtoUpdateToEntity(mascota));
        }else{
            throw new DataException("La mascota que intento actualizar no existe");
        }
    }

    @Override
    public List<MascotasConsltaDTO> listarMascotas() throws DataException {
        return Optional.of(mascotaRepository.findAll())
                .filter(c -> !c.isEmpty())
                .map(MascotaMapper.INSTANCE::listEntityToDtoConsulta)
                .orElseThrow(() -> new DataException("No existe ninguna mascota registrada"));
    }

    @Override
    public List<ReporteMascotasDTO> consultarMascotas(Integer idCliente) {
        return mascotaRepository.findByClienteEntity_Id(idCliente).stream()
                .map(this::generarReporteMascota)
                .toList();
    }

    @Override
    public List<MascotasEntity> getAllentities() {
        return mascotaRepository.findAll();
    }

    private ReporteMascotasDTO generarReporteMascota(MascotasEntity entity) {
        ReporteMascotasDTO reporte = MascotaMapper.INSTANCE.entityToReporteDTO(entity);
        reporte.setTratamientos(tratamientoService.reporteTratamientos(entity.getId()));
        return reporte;
    }
}
