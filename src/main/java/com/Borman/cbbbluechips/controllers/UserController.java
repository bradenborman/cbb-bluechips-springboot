package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createNewUser(user);
        System.out.println(String.format("User Created: Id set to %s", user.getID()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/delete/{requestId}")
    ResponseEntity<String> deleteUser(@PathVariable String requestId) {
        userService.deleteUser(requestId);
        return ResponseEntity.ok("User Deleted");
    }

}

