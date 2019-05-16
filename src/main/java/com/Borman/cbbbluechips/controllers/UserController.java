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
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createNewUser(user);
        return ResponseEntity.ok("User Created");
    }


}
