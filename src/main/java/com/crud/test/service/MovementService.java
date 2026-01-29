package com.crud.test.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.test.domain.Account;
import com.crud.test.domain.Movement;
import com.crud.test.repository.AccountRepository;
import com.crud.test.repository.MovementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovementService {
     private final MovementRepository repository;
     private final AccountService service;
     private final AccountRepository accountRepository;

     public Movement crear(Movement movement) {
        Optional<Account> account= accountRepository.findByNumeroCuenta(movement.getAccount().getNumeroCuenta());
        registrarMovimiento(account.get(),movement.getValor());
        Movement guardado = repository.save(movement);
        return guardado;
    }

     public List<Movement> listar() {
        return repository.findAll();
    }

    public Movement obtener(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
    }

    public void registrarMovimiento(Account cuenta, BigDecimal valor) {

    BigDecimal nuevoSaldo = cuenta.getSaldoInicial().add(valor);

    if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
        throw new RuntimeException("Saldo no disponible");
    }

    cuenta.setSaldoInicial(nuevoSaldo);
}
}
