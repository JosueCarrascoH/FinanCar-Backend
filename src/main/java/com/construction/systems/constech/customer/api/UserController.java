package com.construction.systems.constech.customer.api;

import com.construction.systems.constech.customer.domain.model.entities.User;
import com.construction.systems.constech.customer.domain.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Everything about users")
@AllArgsConstructor
@RestController

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> fetchAll() {
        return userService.fetchAll();
    }
}
