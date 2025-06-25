package io.github.mariadev.usecase.account;

import io.github.mariadev.application.dto.account.AccountCreateRequest;
import io.github.mariadev.core.contracts.AccountRepository;
import io.github.mariadev.core.contracts.UserRepository;
import io.github.mariadev.core.domain.Account;
import io.github.mariadev.core.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public Account execute(AccountCreateRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = Account.builder()
                .user(user)
                .balance(request.initialBalance() != null ? request.initialBalance() : BigDecimal.ZERO)
                .build();

        return accountRepository.save(account);
    }
}