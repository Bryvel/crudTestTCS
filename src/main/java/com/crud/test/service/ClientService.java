package com.crud.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.test.domain.Client;
import com.crud.test.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

 private final ClientRepository repository;
     public Client crear(Client client) {

        repository.findByIdentificacion(client.getIdentificacion())
            .ifPresent(c -> {
                throw new RuntimeException("Cliente ya existe");
            });

        Client guardado = repository.save(client);

        return guardado;
    }
     public List<Client> listar() {
        return repository.findAll();
    }
         public Client obtener(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

}
