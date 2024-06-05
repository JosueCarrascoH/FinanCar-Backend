package com.construction.systems.constech.company.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public CompanyMapper studentMapper() {
        return new CompanyMapper();
    }
}
