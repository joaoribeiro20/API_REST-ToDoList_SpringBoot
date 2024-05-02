package com.project.toDoListApiRestSemSpringSecurity.modules.user.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.dto.RequestDataCreateUserDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String id;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    public User(RequestDataCreateUserDto dados) {
        this.name = dados.name();
        this.username = dados.username();
        this.email = dados.email();
        this.password = dados.password();
        this.createdAt = LocalDateTime.now();
    }

}
