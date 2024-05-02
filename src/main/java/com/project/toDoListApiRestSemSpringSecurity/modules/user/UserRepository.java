package com.project.toDoListApiRestSemSpringSecurity.modules.user;

import java.util.Optional;
import java.util.UUID;

import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}