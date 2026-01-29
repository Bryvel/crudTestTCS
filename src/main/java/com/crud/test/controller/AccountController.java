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

import com.crud.test.domain.Account;
import com.crud.test.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class AccountController {
private final AccountService service;
    @PostMapping
    public Account crear(@RequestBody Account account) {
        return service.crear(account);
    }

    @GetMapping
    public List<Account> listar() {
        return service.listar();
    }

    @GetMapping("/{numeroCuenta}")
    public Account obtener(@PathVariable String numeroCuenta) {
        return service.obtener(numeroCuenta);
    }

    @PutMapping("/{numeroCuenta}")
    public Account actualizar(@PathVariable String numeroCuenta,
                              @RequestBody Account account) {
        account.setNumeroCuenta(numeroCuenta);
        return service.crear(account);
    }

    @DeleteMapping("/{numeroCuenta}")
    public void eliminar(@PathVariable String numeroCuenta) {
        service.obtener(numeroCuenta);
    }
}
