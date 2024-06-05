package com.construction.systems.constech.company.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "data")
public class Company {
    @Id//PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="moneda",length = 50,nullable = false)
    private String moneda;


    @Column(name="precioVivienda",length = 50,nullable = false)
    private Number precioVivienda;


    @Column(name="cuotaInicial",length = 50,nullable = false)
    private Number cuotaInicial;


    @Column(name="tasaEfectiva",length = 50,nullable = false)
    private Number tasaEfectiva;



    @Column(name="numeroCuotas",length = 50,nullable = false)
    private Number numeroCuotas;


    @Column(name="periodoGracia",length = 50,nullable = false)
    private Number periodoGracia;


    @Column(name="periodoGraciaParcial",length = 50,nullable = false)
    private Number periodoGraciaParcial;

    @Column(name="periodoGraciaTotal",length = 50,nullable = false)
    private Number periodoGraciaTotal;

    @Column(name="cuota",length = 50,nullable = false)
    private Number cuota;


    @Column(name="userId",length = 50,nullable = false)
    private Number userId;

}
