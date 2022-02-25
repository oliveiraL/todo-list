package br.com.letscode.userapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID externalId;
    private String email;
    private String password;
    private String username;
    private Date createdAt;
    private Date updateAt;

    @PrePersist
    private void preSave() {
        createdAt = new Date();
    }
}
