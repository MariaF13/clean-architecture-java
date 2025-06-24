package io.github.mariadev.core.contracts;

import io.github.mariadev.core.domain.CreditCard;

import java.util.Optional;

public interface CreditCardRepository {
    CreditCard save(CreditCard card);
    Optional<CreditCard> findByAccountId(Long accountId);
}
