package me.robi.springtest.controllers;

import me.robi.springtest.RepositoryHolder;
import me.robi.springtest.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RepositoryHolder repositoryHolder;

    @GetMapping("/list")
    public Iterable<UserEntity> getUsers() {
        return repositoryHolder.users.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestParam(value = "name") String name) {
        if(name.length() < 3)
            return new ResponseEntity(Collections.singletonMap("message", "User must be 3 characters or longer."), HttpStatus.UNPROCESSABLE_ENTITY);
        if(name.length() > 16)
            return new ResponseEntity(Collections.singletonMap("message", "User must be 16 characters or shorter."), HttpStatus.UNPROCESSABLE_ENTITY);
        if(repositoryHolder.users.findByNameIgnoreCase(name) != null)
            return new ResponseEntity(Collections.singletonMap("message", "User with the name already exists."), HttpStatus.CONFLICT);
        UserEntity user = new UserEntity(name);
        repositoryHolder.users.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        response.put("user", user);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
