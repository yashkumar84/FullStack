package com.brainmentors.springmvcjdbc.repo;

import org.springframework.data.repository.CrudRepository;

import com.brainmentors.springmvcjdbc.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    // register
    boolean existsByEmail(String email);

    // login
    Optional<User> findByEmail(String email);
}
