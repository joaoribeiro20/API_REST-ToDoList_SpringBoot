package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.EnumTaskStatus;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResponseDataCreateTaskDto(String id, String title, String description, EnumTaskStatus taskStatus, LocalDateTime createdAt, String userid) {
    public ResponseDataCreateTaskDto(Task task){
        this(task.getId(), task.getTitle(),task.getDescription(), task.getTaskStatus(), task.getCreatedAt(), task.getUser().getId());
    }
}
