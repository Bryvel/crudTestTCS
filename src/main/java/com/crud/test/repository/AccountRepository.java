package com.crud.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
 Optional<Account> findByNumeroCuenta(String numeroCuenta);

}
