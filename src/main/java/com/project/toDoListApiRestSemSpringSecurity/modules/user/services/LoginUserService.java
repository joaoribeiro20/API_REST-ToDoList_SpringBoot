package com.project.toDoListApiRestSemSpringSecurity.modules.user.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginUserService {
    @Autowired
    UserRepository userRepository;
    public User execute(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            if(Objects.equals(password, user.get().getPassword())){
                return user.get();
            }else {
                return null;
            }
        }
        return null;

    }
}
