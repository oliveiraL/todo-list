package br.com.letscode.todolist.service;

import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.exception.TaskNotFoundException;
import br.com.letscode.todolist.repository.TaskRepository;
import br.com.letscode.todolist.util.TaskUtil;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;


@ExtendWith(SpringExtension.class)
public class TaskServiceTest {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Mock
    UserContext userContext;


    @Test
    @DisplayName("save task when success ful")
    void saveTaskWhenSuccessFul(){
        var uuid = UUID.randomUUID();
        var taskOld = TaskUtil.createTask();

        Mockito.when(userContext.getUserId()).thenReturn(uuid);
        Mockito.when(taskRepository.save(taskOld)).thenReturn(
                TaskUtil.createTask(1, uuid)
        );

        var taskSaved = taskService.save(taskOld);

        Assertions.assertThat(taskSaved).isNotNull();
        Assertions.assertThat(taskSaved.getId()).isEqualTo(1);
        Assertions.assertThat(taskSaved.getUserId()).isEqualTo(uuid);
        Assertions.assertThat(taskSaved.getTitle()).isEqualTo("task de test");
    }


    @Test
    void deleteTaskWhenNotFound(){

        Mockito.when(taskRepository.existsById(1)).thenReturn(false);

        Assertions.assertThatThrownBy(() -> taskService.delete(0))
                .isInstanceOf(TaskNotFoundException.class);

        Mockito.verify(taskRepository).existsById(0);
    }

}
