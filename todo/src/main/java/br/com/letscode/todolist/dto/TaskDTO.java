package br.com.letscode.todolist.dto;

import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.State;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TaskDTO(
        Integer id,
        String title,
        String description,
        State state,
        Date createdAt,
        Date updateA,
        List<Comment>comments) {
}
