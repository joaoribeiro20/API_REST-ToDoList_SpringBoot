package com.project.toDoListApiRestSemSpringSecurity.modules.user.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;

    public User execute(User dataUser){
        System.out.println(dataUser.getEmail());
        Optional<User> optionalUser = userRepository.findByUsername(dataUser.getUsername());

        if (optionalUser.isPresent()){
            return null;
        }else {
            User newUser = userRepository.save(dataUser);
            return newUser;
        }

    }

}
