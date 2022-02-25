package br.com.letscode.todolist.repository;

import br.com.letscode.todolist.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    List<Task> findByUserId(UUID userID);
}
