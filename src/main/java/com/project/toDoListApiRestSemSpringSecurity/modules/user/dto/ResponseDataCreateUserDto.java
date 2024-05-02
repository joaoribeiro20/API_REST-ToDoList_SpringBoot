package com.project.toDoListApiRestSemSpringSecurity.modules.user.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;

import java.time.LocalDateTime;

public record ResponseDataCreateUserDto(String id,
                                        String name,
                                        String username,
                                        String password,
                                        String email,
                                        LocalDateTime createdAt) {
    public ResponseDataCreateUserDto(User user){
        this(user.getId(),user.getName(),user.getUsername(), user.getPassword(),user.getEmail(), user.getCreatedAt() );
    }

}
