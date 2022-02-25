package br.com.letscode.todolist.client.dto;

import java.util.UUID;

public record UserDTO(
        UUID externalId,
        String email,
        String username
) {
}
