package com.example.pets.contoller;

import com.example.pets.dto.ClienteConsulta;
import com.example.pets.dto.ClientePersistencia;
import com.example.pets.dto.ClienteUpdate;
import com.example.pets.dto.Mensaje;
import com.example.pets.service.IClientesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClientesController {

    private final IClientesService clientesService;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> crearCliente(@RequestBody @Valid ClientePersistencia cliente) {
        clientesService.crearCliente(cliente);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Cliente creado").build());
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<Mensaje> eliminarCliente(@PathVariable Integer idCliente) {
        clientesService.eliminarCliente(idCliente);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Cliente eliminado").build());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteConsulta>> consultarClientes() {
        return ResponseEntity.ok(clientesService.listarClientes());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizarCliente(@RequestBody @Valid ClienteUpdate cliente) {
        clientesService.actualizarCliente(cliente);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Cliente actualizado").build());
    }
}
