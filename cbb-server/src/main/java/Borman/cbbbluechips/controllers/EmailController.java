package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.services.PasswordRecoveringService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private PasswordRecoveringService passwordRecoveringService;

    public EmailController(PasswordRecoveringService passwordRecoveringService) {
        this.passwordRecoveringService = passwordRecoveringService;
    }

    @PostMapping("/recover")
    public String forgotPassword(@RequestParam(value = "emailToRecover") String emailToRecover) {
        return passwordRecoveringService.getUsersPassword(emailToRecover);
    }

}