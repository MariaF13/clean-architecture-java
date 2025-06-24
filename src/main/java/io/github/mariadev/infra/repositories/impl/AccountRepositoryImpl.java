package io.github.mariadev.infra.repositories.impl;

import io.github.mariadev.core.contracts.AccountRepository;
import io.github.mariadev.core.domain.Account;
import io.github.mariadev.infra.repositories.jpa.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final JpaAccountRepository jpa;

    public Account save(Account account) {
        return jpa.save(account);
    }

    public Optional<Account> findById(Long id) {
        return jpa.findById(id);
    }

    public Optional<Account> findByUserId(Long userId) {
        return jpa.findByUserId(userId);
    }
}