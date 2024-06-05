package com.solar.code.model;

import jakarta.persistence.*;
@Entity
@Table(name="Data")
public class Producto {
  // ATRIBUTOS
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String moneda;

  @Column
  private Number precioVivienda;

  @Column
  private Number cuotaInicial;

  @Column
  private Number tasaEfectiva;

  @Column
  private Number numeroCuotas;

  @Column
  private Number periodoGracia;

  @Column
  private Number periodoGraciaParcial;

  @Column
  private Number periodoGraciaTotal;

  @Column
  private Number cuota;

  @Column
  private Number userId;

  // CONSTRUCTORES
  public Producto() {
  }

  public Producto(Long id, String moneda, Number precioVivienda, Number cuotaInicial, Number tasaEfectiva,
                  Number numeroCuotas, Number periodoGracia, Number periodoGraciaParcial, Number periodoGraciaTotal, Number cuota, Number userId) {
    this.id = id;
    this.moneda = moneda;
    this.precioVivienda = precioVivienda;
    this.cuotaInicial = cuotaInicial;
    this.tasaEfectiva = tasaEfectiva;
    this.numeroCuotas = numeroCuotas;
    this.periodoGracia = periodoGracia;
    this.periodoGraciaParcial = periodoGraciaParcial;
    this.periodoGraciaTotal = periodoGraciaTotal;
    this.cuota = cuota;
    this.userId = userId;
  }

  // GETTERS
  public Long getId() {
    return id;
  }

  public String getMoneda() {
    return moneda;
  }

  public Number getPrecioVivienda() {
    return precioVivienda;
  }

  public Number getCuotaInicial() {
    return cuotaInicial;
  }

  public Number getTasaEfectiva() {
    return tasaEfectiva;
  }

  public Number getNumeroCuotas() {
    return numeroCuotas;
  }

  public Number getPeriodoGracia() {
    return periodoGracia;
  }

  public Number getPeriodoGraciaParcial() {
    return periodoGraciaParcial;
  }

  public Number getPeriodoGraciaTotal() {
    return periodoGraciaTotal;
  }

  public Number getCuota() {
    return cuota;
  }

  public Number getUserId() {
    return userId;
  }

  // SETTERS
  public void setId(Long id) {
    this.id = id;
  }

  public void setMoneda(String moneda) {
    this.moneda = moneda;
  }

  public void setPrecioVivienda(Number precioVivienda) {
    this.precioVivienda = precioVivienda;
  }

  public void setCuotaInicial(Number cuotaInicial) {
    this.cuotaInicial = cuotaInicial;
  }

  public void setTasaEfectiva(Number tasaEfectiva) {
    this.tasaEfectiva = tasaEfectiva;
  }

  public void setNumeroCuotas(Number numeroCuotas) {
    this.numeroCuotas = numeroCuotas;
  }

  public void setPeriodoGracia(Number periodoGracia) {
    this.periodoGracia = periodoGracia;
  }

  public void setPeriodoGraciaParcial(Number periodoGraciaParcial) {
    this.periodoGraciaParcial = periodoGraciaParcial;
  }

  public void setPeriodoGraciaTotal(Number periodoGraciaTotal) {
    this.periodoGraciaTotal = periodoGraciaTotal;
  }

  public void setCuota(Number cuota) {
    this.cuota = cuota;
  }

  public void setUserId(Number userId) {
    this.userId = userId;
  }
}
