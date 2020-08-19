package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.OwnsService;
import com.Borman.cbbbluechips.services.TransactionService;
import com.Borman.cbbbluechips.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private CookieService cookieService;
    private OwnsService ownsService;
    private TransactionService transactionService;

    public UserController(UserService userService, CookieService cookieService, OwnsService ownsService, TransactionService transactionService) {
        this.userService = userService;
        this.cookieService = cookieService;
        this.ownsService = ownsService;
        this.transactionService = transactionService;
    }

    //TODO Look at way to auto login or forward to '/
    @PostMapping("/create")
    public String createUser(@RequestParam(value = "fname") String fname,
                             @RequestParam(value = "lname") String lname,
                             @RequestParam(value = "email_new") String email_new,
                             @RequestParam(value = "password_new") String password_new) {
        User user = userService.createNewUser(fname, lname, email_new, password_new);
        if (user != null) {
            if (user.getID() != null) {
                return "redirect:../portfolio";
            }
        }
        return "redirect:../";
    }

    @PostMapping("/delete")
    String deleteUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        deleteAllTracesFromUser(user.getID());
        return "redirect:../";
    }

    @Transactional
    private void deleteAllTracesFromUser(String userId) {
        transactionService.deleteUser(userId);
        ownsService.deleteUser(userId);
        userService.deleteUser(userId);
    }

}

