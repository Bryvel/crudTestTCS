package com.crud.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.test.domain.Client;
import com.crud.test.service.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientController {

private final ClientService service;

    @PostMapping
    public Client crear(@RequestBody Client cliente) {
        return service.crear(cliente);
    }

    @GetMapping
    public List<Client> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Client obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Client actualizar(@PathVariable Long id,
                              @RequestBody Client cliente) {
        cliente.setClienteId(id);
        return service.crear(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.obtener(id);
    }

}
