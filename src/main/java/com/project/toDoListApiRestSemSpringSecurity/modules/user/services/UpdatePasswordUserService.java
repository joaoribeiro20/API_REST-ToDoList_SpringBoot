package com.project.toDoListApiRestSemSpringSecurity.modules.user.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.dto.RequestUpdatePasswordUserDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePasswordUserService {

    @Autowired
    UserRepository userRepository;

    public boolean execute(String id, RequestUpdatePasswordUserDto password){
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()){
            userExist.get().setPassword(password.password());
            userRepository.save(userExist.get());
            return true;
        }
        return false;
    }
}
