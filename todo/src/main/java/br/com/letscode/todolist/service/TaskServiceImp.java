package br.com.letscode.todolist.service;

import br.com.letscode.todolist.client.UserApiClient;
import br.com.letscode.todolist.config.UserContext;
import br.com.letscode.todolist.exception.TaskNotFoundException;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImp implements TaskService{

    private final TaskRepository taskRepository;
    private final UserContext userContext;
    private final UserApiClient userApiClient;


    @Cacheable(value = "items")
    public List<Task> getAll(){
        var userId = userContext.getUserId();
        var user = userApiClient.getUser(userId);
        return taskRepository.findByUserId(userId);
    }

    public Task getById(Integer id){
        var optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        throw new TaskNotFoundException();
    }

    public Task save(Task task){
        var userId = userContext.getUserId();
        task.setUserId(userId);
        return taskRepository.save(task);
    }


    public void delete(Integer taskId){
        if (!taskRepository.existsById(taskId)){
            throw new TaskNotFoundException();
        }
        taskRepository.deleteById(taskId);
    }


    public Task update(Task task, Integer taskId){
        return taskRepository.findById(taskId)
                .map(taskOld -> merge(taskOld, task))
                .map(taskRepository::save)
                .orElseThrow(TaskNotFoundException::new);
    }

    private Task merge(Task old, Task taskNew) {
        var build = old.toBuilder();
        if (StringUtils.isNotEmpty(taskNew.getDescription()))
            build.description(taskNew.getDescription());
        if (taskNew.getState() != null)
            build.state(taskNew.getState());
        if (StringUtils.isNotEmpty(taskNew.getTitle()))
            build.title(taskNew.getTitle());
        return build.build();
    }
}
