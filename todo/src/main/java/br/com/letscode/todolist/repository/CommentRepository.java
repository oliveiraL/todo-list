package br.com.letscode.todolist.repository;

import br.com.letscode.todolist.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
