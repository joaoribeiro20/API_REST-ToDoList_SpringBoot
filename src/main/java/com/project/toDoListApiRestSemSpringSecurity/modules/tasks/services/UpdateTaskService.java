package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.TaskRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.RequestDataUpdateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UpdateTaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task execute(RequestDataUpdateTaskDto task){
        Optional<Task> updateTask = taskRepository.findById(task.id());
        if (updateTask.isPresent()) {
            if(!updateTask.get().getTitle().equals(task.title())) {
                updateTask.get().setTitle(task.title());
            }
            if(!updateTask.get().getDescription().equals(task.description())) {
                updateTask.get().setDescription(task.description());
            }
            updateTask.get().setUpdateAt(LocalDateTime.now());
            Task newTask = taskRepository.save(updateTask.get());
            return newTask;
        }else{
            return null;
        }
    }
}
