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
    public List<User> retriveAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveOne(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @GetMapping("/users/{id}/posts")
    public List<Posts> retriveAllPosts(@PathVariable int id) {
        List<Posts> posts = userService.findAllPosts(id);
        if (posts == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return posts;
    }

    @GetMapping("/users/{uid}/posts/{pid}")
    public Posts retriveOnePost(@PathVariable int uid, @PathVariable int pid) {
        Posts post = userService.findOnePost(uid, pid);
        if (post == null) {
            throw new UserNotFoundException("id-" + pid);
        }
        return post;
    }

    @PostMapping("/users/{uid}/posts")
    public Posts savePost(@PathVariable int uid, @RequestBody Posts post) {
        Posts savedPost = userService.saveUserPost(uid, post);
        return savedPost;
    }
    @DeleteMapping("/users/{id}")
      public void deleteUser(@PathVariable int id){
        User u=userService.removeUser(id);
        if (u==null)
            throw new UserNotFoundException("id"+id);
}
    @PostMapping("/users")
    public ResponseEntity<?> saveUsers(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
//        return savedUser;
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).body("User is saved");
    }


}
