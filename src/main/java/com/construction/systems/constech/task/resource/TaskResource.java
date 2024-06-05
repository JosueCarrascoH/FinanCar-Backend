package com.construction.systems.constech.task.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TaskResource {
    private Integer id;
    private String assigned;
    private String title;
    private String description;
    private String status;
    private String initialDate;
    private String deadline;
}
