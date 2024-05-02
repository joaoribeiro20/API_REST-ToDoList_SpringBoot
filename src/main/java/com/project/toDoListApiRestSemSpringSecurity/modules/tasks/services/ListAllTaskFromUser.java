package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.TaskRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.UserRepository;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListAllTaskFromUser {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    public List<Task> listAll(String id) {
        List<Task> allTasks = taskRepository.findAllByUserId(id);
        if(allTasks != null){
            System.out.println(allTasks);
            return  allTasks;
        }
        return null;

//        System.out.println(id);
//        List<Task> allTasks = taskRepository.findAll();
//        System.out.println(allTasks);
//        List<Task> tasksWithUserId = allTasks.stream()
//                .filter(task -> task.getUserid().getId().equals(id))
//                .collect(Collectors.toList());
//        return tasksWithUserId;
    }
}
