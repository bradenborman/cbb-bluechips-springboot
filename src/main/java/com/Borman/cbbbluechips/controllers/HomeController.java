package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String welcome(Model model, @RequestParam(defaultValue = "false") String wasError) {
        if (!wasError.equals("false"))
            model.addAttribute("error", "Failed");

        return !"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName()) ? "redirect:/portfolio" : "home";
    }

    @RequestMapping("/settings")
    public String settings(Model model) {
        String userid = getLoggedInUser().getID();
        model.addAttribute("textAlert", userService.doesUserSubscribeToTextAlerts(userid));
        model.addAttribute("phoneNumber", userService.getUserPhoneNumber(userid));
        return "settings";
    }

    @PostMapping("/settings/updateTextAlert")
    public ResponseEntity<String> updateTextAlert(@RequestParam(value = "textStatus") boolean textStatus) {
        userService.toggleTextAlertSubscription(textStatus, getLoggedInUser().getID());
        return ResponseEntity.ok("OKAY");
    }

    @PostMapping("/settings/updatePhoneNumber")
    public ResponseEntity<String> updatePhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber) {
        userService.updatePhoneNumber(phoneNumber, getLoggedInUser().getID());
        return ResponseEntity.ok("OKAY");
    }

    private User getLoggedInUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}