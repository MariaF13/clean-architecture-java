package io.github.mariadev.infra.repositories.impl;

import io.github.mariadev.core.contracts.CreditCardRepository;
import io.github.mariadev.core.domain.CreditCard;
import io.github.mariadev.infra.repositories.jpa.JpaCreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CreditCardRepositoryImpl implements CreditCardRepository {

    private final JpaCreditCardRepository jpa;

    public CreditCard save(CreditCard card) {
        return jpa.save(card);
    }

    public Optional<CreditCard> findByAccountId(Long accountId) {
        return jpa.findByAccountId(accountId);
    }
}