package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;

import java.time.LocalDateTime;

public record RequestDataCreateTaskDto(String title, String description,String userid) {
}
