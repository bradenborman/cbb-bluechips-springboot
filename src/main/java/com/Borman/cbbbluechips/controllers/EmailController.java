package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.email.EmailService;
import com.Borman.cbbbluechips.services.PasswordRecoveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {


    @Autowired
    EmailService emailService;

    @Autowired
    PasswordRecoveringService passwordRecoveringService;

    @GetMapping("/test")
    public String createUser() {
        emailService.sendTESTEmail();
        return "Tested";
    }


    @PostMapping("/recover")
    public String forgotPassword(@RequestParam(value = "emailToRecover") String emailToRecover) {
        return passwordRecoveringService.getUsersPassword(emailToRecover);
    }

}