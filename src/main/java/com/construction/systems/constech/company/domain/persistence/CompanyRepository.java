package com.construction.systems.constech.company.domain.persistence;

import com.construction.systems.constech.company.domain.model.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByMoneda(String moneda);

}
