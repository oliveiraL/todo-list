package br.com.letscode.todolist.controller;

import br.com.letscode.todolist.converts.TaskMapper;
import br.com.letscode.todolist.dto.TaskCreateDTO;
import br.com.letscode.todolist.dto.TaskDTO;
import br.com.letscode.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Transactional
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @GetMapping
    @Cacheable(value = "tasks")
    public List<TaskDTO> getAll(){
        var list =  taskService.getAll().stream().map(taskMapper::taskToTaskDTO).toList();
        return list;
    }

    @GetMapping("/{id}")
//    @Cacheable(value = "task", key = "#id")
    public TaskDTO getById(@PathVariable  Integer id){
        var taskDTO = taskMapper.taskToTaskDTO(taskService.getById(id));
        return taskDTO;
    }

    @PostMapping
//    @CacheEvict(cacheNames = "tasks", allEntries = true)
    public ResponseEntity<TaskDTO> save(@Valid @RequestBody TaskCreateDTO taskCreateDTO){
        var task = taskService.save(taskMapper.taskCreateDTOTOTask(taskCreateDTO));
        return ResponseEntity.ok(taskMapper.taskToTaskDTO(task));
    }


    @PutMapping("/{id}")
//    @CacheEvict(cacheNames = "task", key = "#id")
    public ResponseEntity<TaskDTO> update(@Valid @RequestBody TaskCreateDTO taskCreateDTO, @PathVariable  Integer id){
        var task = taskService.update(taskMapper.taskCreateDTOTOTask(taskCreateDTO), id);
        return ResponseEntity.ok(taskMapper.taskToTaskDTO(task));
    }

    @DeleteMapping("/{id}")
//    @CacheEvict(cacheNames = "task", key = "#id")
    public ResponseEntity<Void> delete(@PathVariable  Integer id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }




}
