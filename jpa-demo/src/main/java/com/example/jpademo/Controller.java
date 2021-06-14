package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/user/{id}")
    public User deleteUserById(@PathVariable String id) throws Exception{
        User user = repositoryUser.findById(id).orElseThrow(() -> new Exception("User not found; so, it can't be deleted."));
        repositoryUser.deleteById(user.getId());
        return user;
    }


    // update
}
