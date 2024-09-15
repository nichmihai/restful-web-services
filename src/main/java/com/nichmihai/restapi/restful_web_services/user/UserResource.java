package com.nichmihai.restapi.restful_web_services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @PostMapping("/users")


    public User createUser(@RequestBody User user) {
        return service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable("id") int id) {
        service.removerUser(id);
    }
}
