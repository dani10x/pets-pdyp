package com.example.pets.contoller;
import java.util.List;

import com.example.pets.dto.*;
import com.example.pets.entity.TratamientosEntity;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/listar")
    public ResponseEntity<List<TratamientoConsulta>> consutlarTratamientos(){
        return ResponseEntity.ok(tratamientoService.ListarTratamientos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> EleminarTratamiento(@PathVariable Integer id){
        tratamientoService.EleminarTratamiento(id);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Tratamiento eliminado").build());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> ActualizarTratamiento(@RequestBody TratamientoUpdate tratamiento){
        tratamientoService.ActualizarTratamiento(tratamiento);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Tratamiento actualizada").build());
    }

    @GetMapping("/lstar-tratamientos/{id}")
    public ResponseEntity<List<TratamientoMascotaConsulta>> consultarTratamientosMascota(@PathVariable Integer id) {
        return ResponseEntity.ok(tratamientoService.ListarTratamientos(id));
    }

    @QueryMapping
    public List<TratamientosEntity> getAllTratamientos() {
        return tratamientoService.getAllEntities();
    }

    @MutationMapping
    public Mensaje createTratamiento(@Argument TratamientoPersistencia input) {
        tratamientoService.CrearTratamiento(input);
        return Mensaje.builder().error(false).respuesta("Tratamiento creado").build();
    }
}
