package io.github.mariadev.usecase.user;

import io.github.mariadev.core.contracts.UserRepository;
import io.github.mariadev.core.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User execute(String name, String email) {
        User user = User.builder()
                .nome(name)
                .email(email)
                .build();
        return userRepository.save(user);
    }
}
