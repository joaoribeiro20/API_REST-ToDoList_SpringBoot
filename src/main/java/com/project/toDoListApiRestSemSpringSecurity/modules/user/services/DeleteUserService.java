package com.project.toDoListApiRestSemSpringSecurity.modules.user.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService {

    @Autowired
    UserRepository userRepository;

    public boolean execute(String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }
}
