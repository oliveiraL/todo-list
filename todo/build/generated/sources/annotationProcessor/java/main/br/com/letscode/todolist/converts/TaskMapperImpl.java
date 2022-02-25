package br.com.letscode.todolist.converts;

import br.com.letscode.todolist.dto.TaskCreateDTO;
import br.com.letscode.todolist.dto.TaskDTO;
import br.com.letscode.todolist.model.Comment;
import br.com.letscode.todolist.model.State;
import br.com.letscode.todolist.model.Task;
import br.com.letscode.todolist.model.Task.TaskBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-25T20:22:35-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO taskToTaskDTO(Task task) {
        if ( task == null ) {
            return null;
        }

        Integer id = null;
        String title = null;
        String description = null;
        State state = null;
        Date createdAt = null;
        List<Comment> comments = null;

        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
        state = task.getState();
        createdAt = task.getCreatedAt();
        Collection<Comment> collection = task.getComments();
        if ( collection != null ) {
            comments = new ArrayList<Comment>( collection );
        }

        Date updateA = null;

        TaskDTO taskDTO = new TaskDTO( id, title, description, state, createdAt, updateA, comments );

        return taskDTO;
    }

    @Override
    public Task taskCreateDTOTOTask(TaskCreateDTO taskCreateDTO) {
        if ( taskCreateDTO == null ) {
            return null;
        }

        TaskBuilder task = Task.builder();

        task.title( taskCreateDTO.title() );
        task.description( taskCreateDTO.description() );
        task.state( taskCreateDTO.state() );

        return task.build();
    }
}
