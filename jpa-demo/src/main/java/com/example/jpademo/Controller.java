package com.example.jpademo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
