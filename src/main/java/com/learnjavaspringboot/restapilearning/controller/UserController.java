package com.learnjavaspringboot.restapilearning.controller;

import com.learnjavaspringboot.restapilearning.model.User;
import com.learnjavaspringboot.restapilearning.response.ResponseHandler;
import com.learnjavaspringboot.restapilearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        User userDb = userService.createUser(user);

        return ResponseHandler.generateResponse("User Created", HttpStatus.CREATED, userDb);
    }

    @GetMapping("{userId}")
    public ResponseEntity<Object> getUser(@PathVariable("userId") Integer userId)
    {
        Optional<User> user = userService.getUser(userId);

        if (user.isPresent()) {
            return ResponseHandler.generateResponse("User Found", HttpStatus.OK, user.get());
        }

        return ResponseHandler.generateResponse("User Not Found", HttpStatus.NOT_FOUND, null);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers()
    {
        List<User> users = userService.getAllUsers();

        if (users.size() > 0) {
            return ResponseHandler.generateResponse("All Users list", HttpStatus.OK, users);
        }

        return ResponseHandler.generateResponse("No users found", HttpStatus.NOT_FOUND, null);
    }
}
