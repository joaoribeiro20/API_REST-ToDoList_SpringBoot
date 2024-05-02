package com.project.toDoListApiRestSemSpringSecurity.modules.user.dto;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;

public record RequestDataLoginUserDto(String username, String password) {

}
