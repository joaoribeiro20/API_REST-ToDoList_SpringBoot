package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.TaskRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.RequestDataUpdateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.EnumTaskStatus;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UpdateStatusTaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task execute(String id){
        Optional<Task> updateTask = taskRepository.findById(id);
        if (updateTask.isPresent()) {
            Task task = updateTask.get();
            if(task.getTaskStatus().equals(EnumTaskStatus.pending)){
                task.setTaskStatus(EnumTaskStatus.completed);
            } else if(task.getTaskStatus().equals(EnumTaskStatus.completed)) {
                task.setTaskStatus(EnumTaskStatus.pending);
            } else {
                return null;
            }
            return taskRepository.save(task);
        } else {
            return null;
        }
    }
}
