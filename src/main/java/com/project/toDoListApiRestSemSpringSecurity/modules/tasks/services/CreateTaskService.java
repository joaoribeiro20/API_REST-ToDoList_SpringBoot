package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.TaskRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.RequestDataCreateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    public Task execute(RequestDataCreateTaskDto dados){
        User user = userRepository.findById(dados.userid())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + dados.userid()));

        var task = new Task(dados, user);
        Task newTask = taskRepository.save(task);
        return newTask;
    }
}
