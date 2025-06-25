package io.github.mariadev.usecase.user;

import io.github.mariadev.core.contracts.UserRepository;
import io.github.mariadev.core.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @Test
    void shouldCreateUserSuccessfully() {
        var user = new User(null, "Maria", "maria@email.com", null);
        when(userRepository.save(any(User.class))).thenReturn(user);

        var result = createUserUseCase.execute(user.getName(), user.getEmail());

        assertEquals("Maria", result.getName());
        assertEquals("maria@email.com", result.getEmail());
        verify(userRepository).save(any(User.class));
    }
}
