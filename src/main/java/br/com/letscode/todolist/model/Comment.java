package br.com.letscode.todolist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment{
    @Id
    @GeneratedValue
    private Integer id;
    private Date createdAt;
    private String text;
    @ManyToOne
    private Task task;
}
