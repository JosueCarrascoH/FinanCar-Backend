package com.construction.systems.constech.task.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id//PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    @Column(name="assigned", length = 50, nullable = false)
    private String assigned;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    @Column(name="title", length = 50, nullable = false)
    private String title;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    @Column(name="description", length = 50, nullable = false)
    private String description;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    @Column(name="status", length = 50, nullable = false)
    private String status;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    @Column(name="initial_date", length = 50, nullable = false)
    private String initialDate;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    @Column(name="deadline", length = 50, nullable = false)
    private String deadline;
}
