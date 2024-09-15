package com.example.pets.contoller;

import com.example.pets.dto.ClientePersistencia;
import com.example.pets.dto.Mensaje;
import com.example.pets.service.IClientesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClientesController {

    private final IClientesService clientesService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<Mensaje> crearCliente(@RequestBody @Valid ClientePersistencia cliente) {
        clientesService.crearCliente(cliente);
        return ResponseEntity.ok(Mensaje.builder().error(false).respuesta("Cliente creado").build());
    }
}
