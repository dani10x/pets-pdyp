package com.example.pets.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pets.dto.MascotaPersistencia;
import com.example.pets.dto.Mensaje;
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
    
}
