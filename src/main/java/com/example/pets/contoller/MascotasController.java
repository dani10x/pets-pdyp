package com.example.pets.contoller;

import java.util.List;

import com.example.pets.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pets.service.IMascotaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mascotas")
public class MascotasController {

    private final IMascotaService mascotaService;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> CrearMascotas(@RequestBody MascotaPersistencia mascota){
        mascotaService.CrearMascotas(mascota);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Mascota creada").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> EliminarMascota(@PathVariable Integer id){
        mascotaService.EliminarMascota(id);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Mascota eliminada").build());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MascotaConsulta>> consutlarMascostas(){
        return ResponseEntity.ok(mascotaService.ListarMascotas());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> ActualizarMascota(@RequestBody MascotaUpdate mascota){
        mascotaService.ActualizarMascota(mascota);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Mascota actualizada").build());
    }

    @GetMapping("/listar-mascotas")
    public ResponseEntity<List<MascotasConsltaDTO>> listarMascotas() {
        return ResponseEntity.ok(mascotaService.listarMascotas());
    }

    
}
