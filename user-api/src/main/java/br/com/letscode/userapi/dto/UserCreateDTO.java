package br.com.letscode.userapi.dto;

public record UserCreateDTO(
        String email,
        String password,
        String username
) {
}
