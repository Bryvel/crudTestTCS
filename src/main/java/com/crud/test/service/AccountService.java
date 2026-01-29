package com.crud.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.test.domain.Account;
import com.crud.test.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

     private final AccountRepository repository;
       public Account crear(Account account) {

        repository.findByNumeroCuenta(account.getNumeroCuenta())
            .ifPresent(c -> {
                throw new RuntimeException("Cuenta ya existe");
            });

        Account guardado = repository.save(account);

        return guardado;
    }
     public List<Account> listar() {
        return repository.findAll();
    }
         public Account obtener(String numeroCuenta) {
        return repository.findById(numeroCuenta)
            .orElseThrow(() -> new RuntimeException("Cuenta no encontrado"));
    }
}
