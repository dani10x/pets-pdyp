package com.example.pets.contoller;
import java.util.List;

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

import com.example.pets.dto.MedicamentoConsulta;
import com.example.pets.dto.MedicamentoPersistencia;
import com.example.pets.dto.MedicamentoUpdate;
import com.example.pets.dto.Mensaje;
import com.example.pets.service.IMedicamentosService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicamento")
public class MedicamentosController {
    private final IMedicamentosService medicamentosService;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> CrearMedicamento(@RequestBody @Valid MedicamentoPersistencia medicamento){
        medicamentosService.CrearMedicamento(medicamento);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Medicamento creado").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminarMedicamento(@PathVariable Integer id) {
        medicamentosService.EliminarMedicamento(id);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Medicamento eliminado").build());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MedicamentoConsulta>> ConsultarMedicamentos(){
        return ResponseEntity.ok(medicamentosService.listarMedicamentos());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizarMedicamento(@RequestBody @Valid MedicamentoUpdate medicamento){
        medicamentosService.ActualizarMedicamento(medicamento);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Medicamento actualizado").build());
    }

    @QueryMapping
    public List<MedicamentoConsulta> getAllMedicamentos() {
        return medicamentosService.listarMedicamentos();
    }

    @MutationMapping
    public Mensaje createMedicamento(@Argument MedicamentoPersistencia input) {
        medicamentosService.CrearMedicamento(input);
        return Mensaje.builder().error(false).respuesta("Medicamento creado").build();
    }

    @MutationMapping
    public Mensaje updateMedicamento(@Argument Integer id, @Argument MedicamentoPersistencia input) {
        MedicamentoUpdate medicamento = new MedicamentoUpdate(id, input.getDescripcion(), input.getDosis(),
                input.getNombre());
                medicamentosService.ActualizarMedicamento(medicamento);
        return Mensaje.builder().error(false).respuesta("Medicamento actualizado").build();
    }

    @MutationMapping
    public Mensaje deleteMedicamento(@Argument Integer id) {
        medicamentosService.EliminarMedicamento(id);
        return Mensaje.builder().error(false).respuesta("Medicamento eliminado").build();
    }

}
