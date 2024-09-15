package com.nichmihai.restapi.restful_web_services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI lcoation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        HttpHeaders headers = new HttpHeaders();

        return ResponseEntity.created(lcoation).build();
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable("id") int id) {
        service.removerUser(id);
    }
}
