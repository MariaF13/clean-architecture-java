package io.github.mariadev.usecase.account;

import io.github.mariadev.core.contracts.AccountRepository;
import io.github.mariadev.core.contracts.TransactionRepository;
import io.github.mariadev.core.domain.Account;
import io.github.mariadev.core.domain.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepositUseCaseTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private DepositUseCase depositUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDepositAmountSuccessfully() {
        Long accountId = 1L;
        BigDecimal amount = new BigDecimal("1000.00");
        Account account = Account.builder()
                .id(accountId)
                .balance(new BigDecimal("500.00"))
                .build();

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountRepository.save(any(Account.class))).thenReturn(account);
        when(transactionRepository.save(any(Transaction.class))).thenReturn(null);

        depositUseCase.execute(accountId, amount);

        assertEquals(new BigDecimal("1500.00"), account.getBalance());
        verify(accountRepository, times(1)).save(account);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    void shouldThrowExceptionWhenAccountNotFound() {
        Long accountId = 1L;
        BigDecimal amount = new BigDecimal("1000.00");

        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            depositUseCase.execute(accountId, amount);
        });

        assertEquals("Account not found", exception.getMessage());
    }
}
