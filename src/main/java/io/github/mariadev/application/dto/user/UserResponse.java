package io.github.mariadev.application.dto.user;

public record UserResponse(
        Long id,
        String name,
        String email
) {}