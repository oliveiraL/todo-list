package br.com.letscode.userapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDTO(
        UUID externalId,
        String email,
        String username
) {
}
