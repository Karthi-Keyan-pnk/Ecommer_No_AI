package com.example.CRUD.Controller;

import com.example.CRUD.Module.User;
import com.example.CRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User newUser(@RequestBody User user) {
        return userService.newUser(user);
    }
}
