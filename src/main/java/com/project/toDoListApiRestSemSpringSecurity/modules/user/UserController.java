package com.project.toDoListApiRestSemSpringSecurity.modules.user;


import com.project.toDoListApiRestSemSpringSecurity.modules.user.dto.*;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.entities.User;
import com.project.toDoListApiRestSemSpringSecurity.modules.user.services.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    CreateUserService createUserService;
    @Autowired
    LoginUserService loginUserService;

    @GetMapping()
    public String hello(){
        return "Hello world - Controller from Users";
    }
    @PostMapping()
    @Transactional
    public ResponseEntity create(@RequestBody RequestDataCreateUserDto dados, UriComponentsBuilder uriBuilder) {
        System.out.println(dados.email());
        var user = new User(dados);
        var newUser = createUserService.execute(user);
        if(newUser != null){
            var uri = uriBuilder.path("/customer/{id}").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(uri).body(new ResponseDataCreateUserDto(newUser));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ja existe um Usario com esses dados!!");
        }

    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity login(@RequestBody RequestDataLoginUserDto dados, UriComponentsBuilder uriBuilder) {
        User optionalUser  = loginUserService.execute(dados.username(),dados.password());
        if(optionalUser != null) {
            return ResponseEntity.ok().body(new ResponseDataLoginUserDto(optionalUser));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Dados invalido");
        }

    }
    @Autowired
    UpdateUserService updateUserService;
    @PutMapping
    public  ResponseEntity updateUser(@RequestBody RequestDataUpdateUserDto dados, @RequestHeader("id") String id){
        User updateUser = updateUserService.execute(dados, id);
        if (updateUser != null){
            return ResponseEntity.ok().body(new ResponseDataUpdateUserDto(updateUser));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dados invalido");
    }
    @Autowired
    UpdatePasswordUserService updatePasswordUserService;
    @PatchMapping
    public  ResponseEntity updatePasswordUser(@RequestBody RequestUpdatePasswordUserDto password, @RequestHeader String id){
        var updatePassword = updatePasswordUserService.execute(id, password);
        if(!updatePassword){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao atualizar senha");
        }
        return ResponseEntity.noContent().build();

    }

    @Autowired
    DeleteUserService deleteUserService;
    @DeleteMapping
    @Transactional
    public  ResponseEntity deleterUser(@RequestHeader String id){
        var rest = deleteUserService.execute(id);
        if (rest){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar task" +id);
        }
    }



}
