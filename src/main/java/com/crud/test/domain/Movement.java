package com.crud.test.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movement {

    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long id;
    private LocalDate fecha;
    private BigDecimal valor;
    private BigDecimal saldo;

    @ManyToOne 
    private Account account;
}
