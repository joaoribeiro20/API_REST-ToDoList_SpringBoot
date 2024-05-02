package com.project.toDoListApiRestSemSpringSecurity.modules.tasks;

import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.RequestDataUpdateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.RequestDataCreateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.dto.ResponseDataCreateTaskDto;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities.Task;
import com.project.toDoListApiRestSemSpringSecurity.modules.tasks.services.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @GetMapping()
    public String hello(){
        return "Hello world - Controller from Tasks";
    }
    @Autowired
    CreateTaskService createTaskService;
    @PostMapping()
    @Transactional
    public ResponseEntity create(@RequestBody @Valid RequestDataCreateTaskDto dados, UriComponentsBuilder uriBuilder) {
        var newTask = createTaskService.execute(dados);
        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(newTask.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseDataCreateTaskDto(newTask));
    }
    @Autowired
    ListAllTaskFromUser listAllTaskFromUser;
    @GetMapping("/listTasks")
    public ResponseEntity listAllById(@RequestHeader("id") String id) {
        List<Task> tasks = listAllTaskFromUser.listAll(id);
        if (tasks.isEmpty()) {
            throw new IllegalArgumentException("No tasks found for user with id: " + id);
        }
        return ResponseEntity.ok().body(tasks);
    }
    @Autowired
    UpdateTaskService updateTaskService;
    @PutMapping
    @Transactional
    public ResponseEntity updateTask(@RequestBody @Valid RequestDataUpdateTaskDto dados){
        try {
            var customer = updateTaskService.execute(dados);
            return ResponseEntity.ok(new ResponseDataCreateTaskDto(customer));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar task com Titulo: " + dados.title() + "ID Task Fornecido" + dados.id());
        }

    }
    @Autowired
    UpdateStatusTaskService updateStatusTaskService;
    @PatchMapping()
    @Transactional
    public ResponseEntity updateStatusTaskS(@RequestHeader("id") String id){
        try {
            var customer = updateStatusTaskService.execute(id);
            return ResponseEntity.ok(new ResponseDataCreateTaskDto(customer));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar status da task: " );
        }

    }

    @Autowired
    DeleteOneTaskIdService deleteOneTaskIdService;
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable String id) {
        var rest = deleteOneTaskIdService.deleteTask(id);
        if (rest){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar task" +id);
        }
    }
    @Autowired
    FilterStatusTaskService filterStatusTaskService;
    @GetMapping("/filter/{status}")
    public ResponseEntity filterStatus(@RequestHeader("id") String id, @PathVariable String status) {
        List<Task> tasks = filterStatusTaskService.execute(id,status);
        if (tasks.isEmpty()) {
            //throw new IllegalArgumentException("No tasks found for user with id: " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar task com status: " +status +" (Possiveis status validos no sistema: completed / pending)");
        }
        return ResponseEntity.ok().body(tasks);
    }
}
