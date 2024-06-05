package com.construction.systems.constech.company.mapping;

import com.construction.systems.constech.shared.mapping.EnhancedModelMapper;
import com.construction.systems.constech.company.domain.model.entities.Company;
import com.construction.systems.constech.company.resource.CreateCompanyResource;
import com.construction.systems.constech.company.resource.CompanyResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CompanyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Company toEntity(CreateCompanyResource resource) {
        return this.mapper.map(resource, Company.class);
    }

    public CompanyResource toResource(Company student) {
        return this.mapper.map(student, CompanyResource.class);
    }

}
