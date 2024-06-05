package com.construction.systems.constech.customer.domain.service;

import com.construction.systems.constech.customer.domain.model.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User>fetchAll();
}
