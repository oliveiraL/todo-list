package br.com.letscode.todolist.service;

import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.exception.TaskNotFoundException;
import br.com.letscode.todolist.repository.TaskRepository;
import br.com.letscode.todolist.util.TaskUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@DisplayName("Task Service Test")
class TaskServiceTestWithDataJpaTest {

    @Autowired
    private TaskRepository taskRepository;

    private UserContext userContext = new UserContext();

    private TaskService taskServiceImp;

    @BeforeEach
    void init() {
        taskServiceImp = new TaskService(taskRepository, userContext);
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
        var taskOld = TaskUtil.createTask();

        var taskSaved = taskServiceImp.save(taskOld);

        Assertions.assertThat(taskSaved).isNotNull();
        Assertions.assertThat(taskSaved.getId()).isNotNull();
        Assertions.assertThat(taskSaved.getUserId()).isEqualTo(uuid);
        Assertions.assertThat(taskSaved.getTitle()).isEqualTo("task de test");
    }

    @Test
    void deleteTaskWhenNotFound(){
        Assertions.assertThatThrownBy(() -> taskServiceImp.delete(0))
                .isInstanceOf(TaskNotFoundException.class);

        assertThrows(TaskNotFoundException.class, () -> taskServiceImp.delete(0));
    }

}