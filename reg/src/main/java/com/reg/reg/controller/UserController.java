package com.reg.reg.controller;

import com.reg.reg.model.User;
import com.reg.reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/login/{regid}")
    public ResponseEntity<User> login(@PathVariable("regid") long id) {
        User user = userService.login(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{userid}")
    public ResponseEntity<User> deleteUser(@PathVariable("userid") Long id) {
        userService.deleteUser(id);
        return  new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PutMapping("/user/{userid}")
    public ResponseEntity<User> updateUser(@PathVariable("userid") Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return  new ResponseEntity<>(null,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
