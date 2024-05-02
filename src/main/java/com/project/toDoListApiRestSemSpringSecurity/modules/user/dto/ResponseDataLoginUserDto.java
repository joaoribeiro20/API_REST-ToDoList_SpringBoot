package com.project.toDoListApiRestSemSpringSecurity.modules.user.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseDataLoginUserDto(String id,
                                       String name,
                                       String username,
                                       String email,
                                       LocalDateTime createdAt,
                                       List<Task> tasks) {
    public ResponseDataLoginUserDto(User user) {
        this(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getTasks());
    }
}
