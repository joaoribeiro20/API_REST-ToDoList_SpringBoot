package com.project.toDoListApiRestSemSpringSecurity.modules.user.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;

import java.time.LocalDateTime;

public record ResponseDataUpdateUserDto(String id,
                                        String name,
                                        String username,
                                        String password,
                                        String email,
                                        LocalDateTime createdAt,
                                        LocalDateTime updateAt) {
    public ResponseDataUpdateUserDto(User user){
        this(user.getId(),user.getName(),user.getUsername(), user.getPassword(),user.getEmail(), user.getCreatedAt(),user.getUpdateAt());
    }
}
