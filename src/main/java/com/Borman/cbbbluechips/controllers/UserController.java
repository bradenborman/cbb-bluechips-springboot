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
    public String createUser(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname,
                             @RequestParam(value = "email_new") String email_new, @RequestParam(value = "password_new") String password_new) {
        User user = userService.createNewUser(fname, lname, email_new, password_new);
        if (user != null) {
            if (user.getID() != null || user.getID().equals("0")) {
                cookieService.login(user, response);
                return "redirect:../portfolio";
            }
        }
        return "redirect:../";
    }

    //TODO
    @PostMapping("/delete/{requestId}")
    ResponseEntity<String> deleteUser(@PathVariable String requestId) {
        userService.deleteUser(requestId);
        return ResponseEntity.ok("User Deleted");
    }


    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse
            response, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
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

