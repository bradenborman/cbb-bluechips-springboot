package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    CookieService cookieService;

    //TODO
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        userService.createNewUser(user);
        System.out.println(String.format("User Created: Id set to %s", user.getID()));
        return "portfolio";
    }

    //TODO
    @PostMapping("/delete/{requestId}")
    ResponseEntity<String> deleteUser(@PathVariable String requestId) {
        userService.deleteUser(requestId);
        return ResponseEntity.ok("User Deleted");
    }


    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        User user = userService.attemptToLogIn(email, password);
        if (user != null) {
            cookieService.login(user, response);
            return "redirect:../portfolio";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        cookieService.logout(response);
        return "redirect:../";
    }

}

