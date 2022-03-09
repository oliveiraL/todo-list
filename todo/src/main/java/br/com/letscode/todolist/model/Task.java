package br.com.letscode.todolist.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Task {
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;
        private UUID userId;
        private String title;
        private String description;
        private State state;
        private Date createdAt;
        private Date updateAt;
        @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
        private Collection<Comment> comments;


        @PrePersist
        private void preSave(){
                createdAt = new Date();
        }

        @PreUpdate
        private void preUpdate(){
                updateAt = new Date();
        }
}
