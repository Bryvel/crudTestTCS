package com.crud.test.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends Person{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long clienteId;

    private String contraseña;
    private Boolean estado;

    
    @OneToMany
    @JoinColumn(name = "clienteId")
    @JsonManagedReference
     private List<Account> accounts;
}
