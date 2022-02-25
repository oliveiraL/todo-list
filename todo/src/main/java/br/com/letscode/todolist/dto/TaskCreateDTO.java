package br.com.letscode.todolist.dto;

import br.com.letscode.todolist.model.State;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record TaskCreateDTO(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        State state) {
}
