package io.github.mariadev.infra.repositories.jpa;

import io.github.mariadev.core.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserId(Long userId);
}