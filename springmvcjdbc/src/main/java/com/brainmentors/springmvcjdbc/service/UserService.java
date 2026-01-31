package com.brainmentors.springmvcjdbc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brainmentors.springmvcjdbc.models.User;
import com.brainmentors.springmvcjdbc.repo.UserRepository;

@Service
public class UserService {
    // Doing DI
    // Constructor Injection
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        boolean isExist = userRepository.existsByEmail(user.getEmail());
        if (isExist) {
            return "User Already Exist can't register ❌";
        }
        userRepository.save(user);
        return "User Register SuccessFully !";
    }

    public String login(User user) {
        Optional<User> opt = userRepository.findByEmail(user.getEmail());
        if (opt.isEmpty()) {
            return "Invalid Email or Password";
        }
        User dbUser = opt.get();
        if (dbUser.getPassword().equals(user.getPassword())) {
            return "Welcome " + dbUser.getName();
        } else {
            return "Invalid Email or Password";
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
