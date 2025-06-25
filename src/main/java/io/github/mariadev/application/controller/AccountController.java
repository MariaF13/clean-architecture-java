package io.github.mariadev.application.controller;

import io.github.mariadev.application.dto.DebitRequest;
import io.github.mariadev.application.dto.DepositRequest;
import io.github.mariadev.usecase.DebitUseCase;
import io.github.mariadev.usecase.DepositUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final DepositUseCase depositUseCase;
    private final DebitUseCase debitUseCase;

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
}