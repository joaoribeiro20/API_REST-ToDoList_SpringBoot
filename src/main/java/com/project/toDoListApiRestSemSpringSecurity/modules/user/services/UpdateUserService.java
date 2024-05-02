package com.project.toDoListApiRestSemSpringSecurity.modules.user.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.dto.RequestDataUpdateUserDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UpdateUserService {
    @Autowired
    UserRepository userRepository;


    public User execute(RequestDataUpdateUserDto user, String id){
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()){
            if(!userExist.get().getName().equals(user.name())) {
                userExist.get().setName(user.name());
            }
            if (!userExist.get().getUsername().equals(user.username())){
                userExist.get().setUsername(user.username());
            }
            if (!userExist.get().getEmail().equals(user.email())){
                userExist.get().setEmail(user.email());
            }
            userExist.get().setUpdateAt(LocalDateTime.now());
            userRepository.save(userExist.get());
            return userExist.get();
        }
        return null;
    }


}
