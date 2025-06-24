package io.github.mariadev.infra.repositories.impl;

import io.github.mariadev.core.contracts.TransactionRepository;
import io.github.mariadev.core.domain.Transaction;
import io.github.mariadev.infra.repositories.jpa.JpaTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final JpaTransactionRepository jpa;

    public Transaction save(Transaction transaction) {
        return jpa.save(transaction);
    }

    public List<Transaction> findByAccountId(Long accountId) {
        return jpa.findByAccountId(accountId);
    }

    public List<Transaction> findByAccountIdAndDataHoraBetween(Long accountId, LocalDateTime start, LocalDateTime end) {
        return jpa.findByAccountIdAndDataHoraBetween(accountId, start, end);
    }
}