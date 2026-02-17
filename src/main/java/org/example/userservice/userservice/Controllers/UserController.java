package org.example.userservice.userservice.Controllers;


import org.example.userservice.userservice.Entity.User;
import org.example.userservice.userservice.Modules.UserName;
import org.example.userservice.userservice.Modules.UserRequest;
import org.example.userservice.userservice.Modules.UserResponse;
import org.example.userservice.userservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
        User user = userService.saveUser(userRequest);
        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/name")
    public ResponseEntity<User> createName(@RequestBody UserName userName)
    {
         User user = userService.createName(userName);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id)
    {
        UserResponse userResponse= userService.getUserById(id);
        return ResponseEntity.ok(userResponse);}
}
