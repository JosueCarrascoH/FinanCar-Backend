package com.construction.systems.constech.customer.domain.persistence;

import com.construction.systems.constech.customer.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
