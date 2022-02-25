package br.com.letscode.todolist.dto;

import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.State;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TaskDTO(
        Integer id,
        String title,
        String description,
        State state,
        Date createdAt,
        Date updateA,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Comment>comments) {
}
