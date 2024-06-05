package com.construction.systems.constech.task.mapping;

import com.construction.systems.constech.shared.mapping.EnhancedModelMapper;
import com.construction.systems.constech.task.domain.model.entities.Task;
import com.construction.systems.constech.task.resource.CreateTaskResource;
import com.construction.systems.constech.task.resource.TaskResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TaskMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Task toEntity(CreateTaskResource resource) {
        return this.mapper.map(resource, Task.class);
    }

    public TaskResource toResource(Task student) {
        return this.mapper.map(student, TaskResource.class);
    }

}
