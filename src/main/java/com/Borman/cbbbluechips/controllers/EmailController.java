package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email")
public class EmailController {


    @Autowired
    EmailService emailService;

    @GetMapping("/test")
    public String createUser() {
        emailService.sendEmail();
        return "Tested";
    }


}