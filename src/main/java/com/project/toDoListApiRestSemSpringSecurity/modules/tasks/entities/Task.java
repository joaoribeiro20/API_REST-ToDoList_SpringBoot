package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.RequestDataCreateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private EnumTaskStatus taskStatus;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Task(RequestDataCreateTaskDto dados, User user) {
        this.title = dados.title();
        this.description = dados.description();
        this.taskStatus = EnumTaskStatus.pending;
        this.createdAt = LocalDateTime.now();
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", description='" + description + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", title='" + title + '\'' +
                ", userid='" + user.getId() + '\'' +
                '}';
    }
}
