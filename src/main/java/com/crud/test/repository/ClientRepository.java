package com.crud.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.domain.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
 Optional<Client> findByIdentificacion(String identificacion);

}
