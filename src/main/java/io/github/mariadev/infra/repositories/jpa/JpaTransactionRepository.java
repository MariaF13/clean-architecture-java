package io.github.mariadev.infra.repositories.jpa;

import io.github.mariadev.core.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaTransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByAccountIdAndDateTimeBetween(Long accountId, LocalDateTime start, LocalDateTime end);
}