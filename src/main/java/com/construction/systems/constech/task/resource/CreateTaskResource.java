package com.construction.systems.constech.task.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskResource {

    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    private String assigned;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    private String title;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    private String description;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    private String status;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    private String initialDate;
    @NotNull
    @NotBlank
    @Size(min =2, max = 50)
    private String deadline;
}
