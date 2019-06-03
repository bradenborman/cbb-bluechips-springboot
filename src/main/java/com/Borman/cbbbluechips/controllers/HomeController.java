package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Comment;
import com.Borman.cbbbluechips.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

    private CookieService cookieService;
    private UserService userService;
    private CommentService commentService;

    public HomeController(CookieService cookieService, UserService userService, CommentService commentService) {
        this.cookieService = cookieService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping("/")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        return cookieService.isLoggedIn(request) ? "redirect:/portfolio" : "home";
    }


    @RequestMapping("/comments")
    public String comments(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("comments", commentService.getComments());
        return "comments";
    }

    @RequestMapping("/settings")
    public String settings(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (!cookieService.isLoggedIn(request))
            return "redirect:/";
        String userid = cookieService.getUserIdLoggedIn(request);
        model.addAttribute("textAlert", userService.doesUserSubscribeToTextAlerts(userid));
        return "settings";
    }

    @PostMapping("/settings/updateTextAlert")
    public ResponseEntity<String> updateTextAlert(@RequestParam(value = "textStatus") boolean textStatus, HttpServletRequest request) {
        if (cookieService.isLoggedIn(request))
            userService.toggleTextAlertSubscription(textStatus, cookieService.getUserIdLoggedIn(request));
        return ResponseEntity.ok("OKAY");
    }


}