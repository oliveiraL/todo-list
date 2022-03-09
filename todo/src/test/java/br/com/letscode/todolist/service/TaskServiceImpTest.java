package br.com.letscode.todolist.service;

import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.model.State;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.repository.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Task Service Test")
class TaskServiceImpTest {

    @Autowired
    public TaskRepository taskRepository;

    public UserContext userContext = new UserContext();

    public TaskServiceImp taskServiceImp;

    @BeforeEach
    void init(){
        taskServiceImp = new TaskServiceImp(taskRepository, userContext);
    }

    @Test
    void test(){
        assertNotNull(taskServiceImp);
    }

    @Test
    @DisplayName("save task when success ful")
    void saveTaskWhenSuccessFul(){
        var uuid = UUID.randomUUID();
        userContext.setUserId(uuid);
        var taskSaved = taskServiceImp.save(createTask());
        Assertions.assertThat(taskSaved).isNotNull();
        Assertions.assertThat(taskSaved.getId()).isNotNull();
        Assertions.assertThat(taskSaved.getUserId()).isEqualTo(uuid);
    }

    private Task createTask(){
        return Task.builder()
                .title("task de test")
                .state(State.CREATED)
                .description("Testando service")
                .build();
    }

}