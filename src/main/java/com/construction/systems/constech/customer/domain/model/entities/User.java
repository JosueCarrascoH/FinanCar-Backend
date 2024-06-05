package com.construction.systems.constech.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min=2,max=50)
    @Column(name="name",length = 50,nullable = false)
    private String  name;

    @Column(name="email",length = 50,nullable = false)
    private String email;

    @Column(name="password",length = 50,nullable = false)
    private String password;

    @Column(name="repassword",length = 50,nullable = false)
    private String repassword;
/*
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
    private   Project project;*/


}
