package com.example.jpademo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    RepositoryUser repositoryUser;

    @GetMapping
    public List<User> getUsers(){
        return repositoryUser.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        repositoryUser.save(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id) throws Exception{
        return repositoryUser.findById(id).orElseThrow(() -> new Exception("User not found"));
    }
}
