package io.github.mariadev.infra.repositories.jpa;

import io.github.mariadev.core.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByAccountId(Long accountId);
}