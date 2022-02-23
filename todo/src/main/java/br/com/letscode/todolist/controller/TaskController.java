package br.com.letscode.todolist.controller;

import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable  Integer id){
        return ResponseEntity.ok(taskService.getById(id));
    }


}
