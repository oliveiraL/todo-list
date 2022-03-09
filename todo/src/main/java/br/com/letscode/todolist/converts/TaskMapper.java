package br.com.letscode.todolist.converts;

import br.com.letscode.todolist.dto.TaskCreateDTO;
import br.com.letscode.todolist.dto.TaskDTO;
import br.com.letscode.todolist.model.Task;
import org.mapstruct.Mapper;

import javax.transaction.Transactional;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO taskToTaskDTO(Task task);

    Task taskCreateDTOTOTask(TaskCreateDTO taskCreateDTO);

}
