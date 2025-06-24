package io.github.mariadev.infra.repositories.impl;

import io.github.mariadev.core.contracts.UserRepository;
import io.github.mariadev.core.domain.User;
import io.github.mariadev.infra.repositories.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpa;

    public User save(User user) {
        return jpa.save(user);
    }

    public Optional<User> findById(Long id) {
        return jpa.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return jpa.findByEmail(email);
    }
}