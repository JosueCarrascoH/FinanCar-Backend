package com.construction.systems.constech.company.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResource {
    private Integer id;
    private String moneda;
    private Number precioVivienda;
    private Number cuotaInicial;
    private Number tasaEfectiva;
    private Number numeroCuotas;
    private Number periodoGracia;
    private Number periodoGraciaParcial;
    private Number periodoGraciaTotal;
    private Number cuota;
    private Number userId;

}
