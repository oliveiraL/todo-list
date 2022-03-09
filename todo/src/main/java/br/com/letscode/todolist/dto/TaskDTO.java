package br.com.letscode.todolist.dto;

import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record TaskDTO(
        Integer id,
        String title,
        String description,
        State state,
        @JsonIgnore
        Date createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        Date updateA,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Comment>comments) {
}
