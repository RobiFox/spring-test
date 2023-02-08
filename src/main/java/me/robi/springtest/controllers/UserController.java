package me.robi.springtest.controllers;

import me.robi.springtest.RepositoryHolder;
import me.robi.springtest.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        UserEntity user = new UserEntity(name);
        repositoryHolder.users.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        response.put("user", user);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
