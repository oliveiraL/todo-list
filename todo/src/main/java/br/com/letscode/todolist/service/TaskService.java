package br.com.letscode.todolist.service;

import br.com.letscode.todolist.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task getById(Integer id);
    Task save(Task task);
    void delete(Integer taskId);
    Task update(Task task, Integer taskId);
}
