package com.project.toDoListApiRestSemSpringSecurity.modules.tasks;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.EnumTaskStatus;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findAllByUserId(String id);
    List<Task> findByTaskStatusEqualsAndUserId(EnumTaskStatus status, String id);
}
