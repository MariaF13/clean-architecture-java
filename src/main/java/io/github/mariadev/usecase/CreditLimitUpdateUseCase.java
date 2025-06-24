package io.github.mariadev.usecase;

import io.github.mariadev.core.contracts.AccountRepository;
import io.github.mariadev.core.contracts.CreditCardRepository;
import io.github.mariadev.core.domain.Account;
import io.github.mariadev.core.domain.CreditCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditLimitUpdateUseCase {

    private final AccountRepository accountRepository;
    private final CreditCardRepository creditCardRepository;

    public void execute(Long accountId) {
        Account account = findAccountById(accountId);
        BigDecimal balance = account.getBalance();

        CreditCard card = creditCardRepository.findByAccountId(accountId).orElseGet(() -> {
            CreditCard newCard = new CreditCard();
            newCard.setAccount(account);
            return newCard;
        });

        BigDecimal newLimit = BigDecimal.ZERO;

        if (balance.compareTo(BigDecimal.valueOf(1000)) >= 0) {
            newLimit = balance.multiply(BigDecimal.valueOf(0.1));
        }

        card.setCreditLimit(newLimit);
        creditCardRepository.save(card);

        log.info("Credit limit updated to {} for account {}", newLimit, accountId);
    }

    private Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
