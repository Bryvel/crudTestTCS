package com.crud.test.domain;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
    @Id
    private String numeroCuenta;

    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private Boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "clienteId")
    @JsonBackReference
    private Client cliente;

    
    @OneToMany
    @JoinColumn(name = "numeroCuenta")
    @JsonManagedReference
     private List<Movement> movements;
    
}
