package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.EnumTaskStatus;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;

import java.time.LocalDateTime;

public record ResponseDataUpdateTaskDto(String id, String title, String description, EnumTaskStatus taskStatus, LocalDateTime createdAt,LocalDateTime updateAt, String userid) {
    public ResponseDataUpdateTaskDto(Task task){
        this(task.getId(), task.getTitle(),task.getDescription(), task.getTaskStatus(),task.getCreatedAt(), task.getUpdateAt(), task.getUser().getId());
    }
}
