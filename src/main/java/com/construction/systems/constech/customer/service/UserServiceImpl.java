package com.construction.systems.constech.customer.service;

import com.construction.systems.constech.customer.domain.model.entities.User;
import com.construction.systems.constech.customer.domain.persistence.UserRepository;
import com.construction.systems.constech.customer.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAll() {

        return userRepository.findAll() ;
    }
}
