package io.github.mariadev.usecase;

import io.github.mariadev.core.contracts.AccountRepository;
import io.github.mariadev.core.contracts.TransactionRepository;
import io.github.mariadev.core.domain.Account;
import io.github.mariadev.core.domain.Transaction;
import io.github.mariadev.core.domain.TypeTransaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class DebitUseCase {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public void execute(Long accountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Debit amount must be greater than zero");
        }

        Account account = findAccountById(accountId);

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);

        Transaction transaction = Transaction.builder()
                .account(account)
                .type(TypeTransaction.DEBIT)
                .amount(amount)
                .dateTime(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        log.info("Debit of {} completed for account {}", amount, accountId);
    }

    private Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
