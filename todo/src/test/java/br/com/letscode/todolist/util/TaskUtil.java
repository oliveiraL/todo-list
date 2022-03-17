package br.com.letscode.todolist.util;

import br.com.letscode.todolist.model.State;
import br.com.letscode.todolist.model.Task;

import java.util.UUID;

public class TaskUtil {

    public static Task createTask(){
        return Task.builder()
                .title("task de test")
                .state(State.CREATED)
                .description("Testando service")
                .build();
    }


    public static Task createTask(Integer id, UUID userID){
        return Task.builder()
                .id(id)
                .userId(userID)
                .title("task de test")
                .state(State.CREATED)
                .description("Testando service")
                .build();
    }

}
