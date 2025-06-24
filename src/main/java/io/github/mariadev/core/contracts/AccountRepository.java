package io.github.mariadev.core.contracts;

import io.github.mariadev.core.domain.Account;

import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(Long id);
    Optional<Account> findByUserId(Long userId);
}
