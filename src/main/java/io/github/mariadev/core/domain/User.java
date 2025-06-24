package io.github.mariadev.core.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
}
