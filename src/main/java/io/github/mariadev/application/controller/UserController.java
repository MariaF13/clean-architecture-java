package io.github.mariadev.application.controller;

import io.github.mariadev.application.dto.user.UserRequest;
import io.github.mariadev.application.dto.user.UserResponse;
import io.github.mariadev.usecase.user.CreateUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public UserResponse create(@RequestBody @Valid UserRequest dto) {
        var user = createUserUseCase.execute(dto.name(), dto.email());
        return new UserResponse(user.getId(), user.getNome(), user.getEmail());
    }
}
