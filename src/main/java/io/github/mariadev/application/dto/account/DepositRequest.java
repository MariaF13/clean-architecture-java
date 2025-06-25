package io.github.mariadev.application.dto.account;

import java.math.BigDecimal;

public record DepositRequest(BigDecimal amount) { }