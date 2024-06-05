package com.construction.systems.constech.customer.domain.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="banks")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min=2,max=50)
    @Column(name="title",length = 50,nullable = false)
    private String  title;

    @Column(name="name",length = 50,nullable = false)
    private String name;

    @Column(name="description",length = 50,nullable = false)
    private String description;

    @Column(name="client_name", length = 50)
    private String clientName;

    @Email(message = "El correo electrónico del cliente debe tener un formato válido")
    @Column(name="client_email",length = 50)
    private String clientEmail;

    @Column(name="status", length = 20)
    private String status;

    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

/*
    @OneToMany(mappedBy = "engineer")
    private List<Engineer> engineer;*/

    public Project() {

        this.startDate = new Date();
        this.endDate = calculateEndDate(this.startDate);
        this.status = "proceso";
    }

    private Date calculateEndDate(Date startDate) {
        LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEndDate = localStartDate.plusMonths(1);
        return Date.from(localEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}

