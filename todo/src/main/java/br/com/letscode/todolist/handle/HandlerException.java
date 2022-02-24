package br.com.letscode.todolist.handle;

import br.com.letscode.todolist.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


record Error(
        String message,
        String description
){}

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({TaskNotFoundException.class, })
    public ResponseEntity<Error> hadlerTaskNotFound(){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("not found", "error"));
    }

}
