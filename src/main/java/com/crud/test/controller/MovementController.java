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

import com.crud.test.domain.Movement;
import com.crud.test.service.MovementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovementController {
private final MovementService service;
    @PostMapping
    public Movement crear(@RequestBody Movement movement) {
        return service.crear(movement);
    }

    @GetMapping
    public List<Movement> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Movement obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Movement actualizar(@PathVariable Long id,
                              @RequestBody Movement movement) {
        movement.setId(id);;
        return service.crear(movement);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.obtener(id);
    }

}
