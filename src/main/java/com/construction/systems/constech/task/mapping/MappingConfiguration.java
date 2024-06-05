package com.construction.systems.constech.task.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("taskMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TaskMapper taskMapper() {
        return new TaskMapper();
    }
}
