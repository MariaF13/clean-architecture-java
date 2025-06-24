package io.github.mariadev.core.contracts;

import io.github.mariadev.core.domain.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByAccountIdAndDataHoraBetween(Long accountId, LocalDateTime start, LocalDateTime end);
}
