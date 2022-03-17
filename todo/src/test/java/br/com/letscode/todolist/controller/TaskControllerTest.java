package br.com.letscode.todolist.controller;

import br.com.letscode.todolist.dto.TaskDTO;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.util.TaskUtil;
import br.com.letscode.todolist.utils.JwtUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class TaskControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    void saveTaskWhenSuccessFul(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth("token");
        HttpEntity<Task> entity = new HttpEntity<>(TaskUtil.createTask(), httpHeaders);

        Mockito.when(jwtUtil.getUserFromToken("token"))
                .thenReturn(UUID.randomUUID().toString());

        ResponseEntity<TaskDTO> response = testRestTemplate.postForEntity("/api/tasks", entity, TaskDTO.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        var task = response.getBody();
        Assertions.assertThat(task).isNotNull();
        Assertions.assertThat(task.id()).isEqualTo(1);
        Assertions.assertThat(task.title()).isEqualTo("task de test");
    }

}