package io.github.mariadev.core.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TypeTransaction tipo;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
