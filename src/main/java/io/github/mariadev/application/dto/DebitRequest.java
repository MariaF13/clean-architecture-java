package io.github.mariadev.application.dto;

import java.math.BigDecimal;

public record DebitRequest(BigDecimal amount) { }