package com.construction.systems.constech.company.domain.service;

import com.construction.systems.constech.company.domain.model.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(Company company);
    List<Company> fetchAll();

    Company fetchByMoneda(String moneda);

    Company update(Integer id,Company company);

    boolean deleteById(Integer id);

}
