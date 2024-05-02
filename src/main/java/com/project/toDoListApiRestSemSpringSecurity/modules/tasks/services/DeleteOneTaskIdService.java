package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.TaskRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteOneTaskIdService {

    @Autowired
    TaskRepository taskRepository;

    public boolean deleteTask(String id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            taskRepository.deleteById(id);
            Optional<Task> validTask = taskRepository.findById(id);
            if (!validTask.isPresent()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
