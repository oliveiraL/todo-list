package br.com.letscode.userapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserLoginDTO(
        String password,
        String username
) {
}
