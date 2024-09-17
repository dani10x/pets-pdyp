package com.example.pets.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pets.dto.Mensaje;
import com.example.pets.dto.TratamientoPersistencia;
import com.example.pets.service.ITratamientoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tratamiento")
public class TratamientosController {
    private final ITratamientoService tratamientoService;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> CrearTratamiento(@RequestBody TratamientoPersistencia tratamiento){
        tratamientoService.CrearTratamiento(tratamiento);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Tratamiento creado").build());
    }
}
