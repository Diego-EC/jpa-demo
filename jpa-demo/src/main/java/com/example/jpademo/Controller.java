package com.example.jpademo;

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

    @DeleteMapping("/user/{id}")
    public User deleteUserById(@PathVariable String id) throws Exception{
        User user = repositoryUser.findById(id).orElseThrow(() -> new Exception("User not found; so, it can't be deleted."));
        repositoryUser.deleteById(user.getId());
        return user;
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody User user) throws Exception{
        User userToUpdate = repositoryUser.findById(user.getId()).orElseThrow(() -> new Exception("User not found; so, it can't be updated."));
        // TODO: ¿hay una forma de detectar los cambios para no hacer set de todos los campos?
        userToUpdate.setName(user.getName());
        userToUpdate.setCity(user.getCity());
        userToUpdate.setAge(user.getAge());
        repositoryUser.save(userToUpdate);
        return "User with id " + user.getId() + " updated";
    }
}
