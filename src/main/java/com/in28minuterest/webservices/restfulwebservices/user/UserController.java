package com.in28minuterest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public List<User> retriveAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveOne(@PathVariable int id){
        User user=userService.findOne(id);
        if(user==null) {
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUsers(@RequestBody User user){
        User savedUser=userService.saveUser(user);
//        return savedUser;
        URI location=ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
