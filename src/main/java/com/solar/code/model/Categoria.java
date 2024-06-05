package com.solar.code.model;

import jakarta.persistence.*;

@Entity
@Table(name="User")
public class Categoria {
  // ATRIBUTOS
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String email;

  @Column(unique = true)
  private String password;

  @Column(unique = true)
  private String repassword;

  // CONSTRUCTORES
  public Categoria() {
  }

  public Categoria(Long id, String name, String email, String password, String repassword) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.repassword = repassword;
  }

  // GETTERS
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getRepassword() {
    return repassword;
  }

  // SETTERS
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRepassword(String repassword) {
    this.repassword = repassword;
  }
}
