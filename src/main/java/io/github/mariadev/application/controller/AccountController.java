package io.github.mariadev.application.controller;

import io.github.mariadev.application.dto.account.AccountCreateRequest;
import io.github.mariadev.application.dto.account.DebitRequest;
import io.github.mariadev.application.dto.account.DepositRequest;
import io.github.mariadev.core.domain.Account;
import io.github.mariadev.usecase.account.CreateAccountUseCase;
import io.github.mariadev.usecase.account.DebitUseCase;
import io.github.mariadev.usecase.account.DepositUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final DepositUseCase depositUseCase;
    private final DebitUseCase debitUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<Void> deposit(@PathVariable Long accountId, @RequestBody DepositRequest request) {
        depositUseCase.execute(accountId, request.amount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{accountId}/debit")
    public ResponseEntity<Void> debit(@PathVariable Long accountId, @RequestBody DebitRequest request) {
        debitUseCase.execute(accountId, request.amount());
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountCreateRequest request) {
        Account account = createAccountUseCase.execute(request);
        return ResponseEntity.ok(account);
    }
}