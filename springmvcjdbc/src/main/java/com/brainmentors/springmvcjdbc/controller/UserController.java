package com.brainmentors.springmvcjdbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.springmvcjdbc.models.User;
import com.brainmentors.springmvcjdbc.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    // DI
    private UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String message = userService.login(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(message);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        String message = userService.register(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(message);
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(users);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot with JDBC";
    }
}
