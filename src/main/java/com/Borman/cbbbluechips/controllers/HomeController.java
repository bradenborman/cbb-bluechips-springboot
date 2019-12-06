package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Comment;
import com.Borman.cbbbluechips.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    private CookieService cookieService;
    private UserService userService;

    public HomeController(CookieService cookieService, UserService userService) {
        this.cookieService = cookieService;
        this.userService = userService;
    }

    //TODO could add the emailAttempted to template but at least it shows in url.
    @RequestMapping("/")
    public String welcome(HttpServletRequest request, HttpServletResponse response, Model model,
                          @RequestParam(defaultValue = "false") String wasError,
                          @RequestParam(defaultValue = "") String emailAttempted) {

        if(!wasError.equals("false"))
            model.addAttribute("error", "Failed");
        return cookieService.isLoggedIn(request) ? "redirect:/portfolio" : "home";
    }

    @RequestMapping("/settings")
    public String settings(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (!cookieService.isLoggedIn(request))
            return "redirect:/";
        String userid = cookieService.getUserIdLoggedIn(request);
        model.addAttribute("textAlert", userService.doesUserSubscribeToTextAlerts(userid));
        model.addAttribute("phoneNumber", userService.getUserPhoneNumber(userid));
        return "settings";
    }

    @PostMapping("/settings/updateTextAlert")
    public ResponseEntity<String> updateTextAlert(@RequestParam(value = "textStatus") boolean textStatus, HttpServletRequest request) {
        if (cookieService.isLoggedIn(request))
            userService.toggleTextAlertSubscription(textStatus, cookieService.getUserIdLoggedIn(request));
        return ResponseEntity.ok("OKAY");
    }

    @PostMapping("/settings/updatePhoneNumber")
    public ResponseEntity<String> updatePhoneNumber(HttpServletRequest request, @RequestParam(value = "phoneNumber") String phoneNumber) {
        System.out.println(String.format("Request to change Phone Number: %s", phoneNumber));
        if (cookieService.isLoggedIn(request))
            userService.updatePhoneNumber(phoneNumber, cookieService.getUserIdLoggedIn(request));
        return ResponseEntity.ok("OKAY");
    }

}