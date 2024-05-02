package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.TaskRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.EnumTaskStatus;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterStatusTaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> execute( String id,String status){
        EnumTaskStatus taskStatus = EnumTaskStatus.filterStatus(status);
        List<Task> filterTask = taskRepository.findByTaskStatusEqualsAndUserId(taskStatus, id);
        if(filterTask != null){
            System.out.println(filterTask);
            return  filterTask;
        }

        return null;
    }
}
