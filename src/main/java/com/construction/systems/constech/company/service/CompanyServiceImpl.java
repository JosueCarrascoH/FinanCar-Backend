package com.construction.systems.constech.company.service;

import com.construction.systems.constech.shared.exception.FetchIdNotFoundException;
import com.construction.systems.constech.shared.exception.ResourceNotFoundException;
import com.construction.systems.constech.shared.exception.ResourceValidationException;
import com.construction.systems.constech.company.domain.model.entities.Company;
import com.construction.systems.constech.company.domain.persistence.CompanyRepository;
import com.construction.systems.constech.company.domain.service.CompanyService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final Validator validator;

    @Transactional
    @Override
    public Company save(Company company) {
        Set<ConstraintViolation<Company>> violations = validator.validate(company);
        if (violations.isEmpty()){
            return companyRepository.save(company);
        }
        throw new ResourceValidationException("Company", violations);
    }


    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (companyRepository.existsById(id)) { // cuando la respuesta de busqueda es un solo elemento
            companyRepository.deleteById(id);
            if (companyRepository.existsById(id)) // Validar que se elimino
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Company", id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> fetchAll() { return companyRepository.findAll(); }

    @Override
    public Company fetchByMoneda(String moneda) {
        Optional<Company> optionalCompany = companyRepository.findByMoneda(moneda);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        throw  new ResourceNotFoundException("Company", "title", moneda);
    }



    @Transactional
    @Override
    public Company update(Integer id, Company request) {

        Set<ConstraintViolation<Company>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException("Company", violations);
        }


        Company updatedCompany = companyRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setMoneda(request.getMoneda());
                    existingCompany.setPrecioVivienda(request.getPrecioVivienda());
                    existingCompany.setCuotaInicial(request.getCuotaInicial());
                    existingCompany.setTasaEfectiva(request.getTasaEfectiva());
                    existingCompany.setNumeroCuotas(request.getNumeroCuotas());
                    existingCompany.setPeriodoGracia(request.getPeriodoGracia());
                    existingCompany.setPeriodoGraciaParcial(request.getPeriodoGraciaParcial());
                    existingCompany.setPeriodoGraciaTotal(request.getPeriodoGraciaTotal());
                    existingCompany.setCuota(request.getCuota());
                    existingCompany.setUserId(request.getUserId());
                    return companyRepository.save(existingCompany);
                })
                .orElseThrow(() -> new FetchIdNotFoundException("Company", id));


        return updatedCompany;
    }
}

