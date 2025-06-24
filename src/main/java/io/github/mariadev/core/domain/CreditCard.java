package io.github.mariadev.core.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal creditLimit;

    private LocalDate lastUpdateDate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
