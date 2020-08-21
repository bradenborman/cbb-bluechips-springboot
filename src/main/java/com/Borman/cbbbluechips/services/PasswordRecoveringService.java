package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.email.EmailService;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.Borman.cbbbluechips.zdata.PasswordRecoveryData.GENERIC_FAILED_MESSAGE;
import static com.Borman.cbbbluechips.zdata.PasswordRecoveryData.GENERIC_SUCCESS_MESSAGE;

@Service
public class PasswordRecoveringService {

    Logger logger = LoggerFactory.getLogger(PasswordRecoveringService.class);

    private UserService userService;
    private EmailService emailService;

    public PasswordRecoveringService(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    public String getUsersPassword(String emailToRecover) {
        logger.info("Attempting to recover password for: " + emailToRecover);
        User user = userService.getUserByEmail(emailToRecover);

        if (user != null && user.getPassword() != null)
            return emailService.sendPasswordRecoveryEmail(emailToRecover, user.getPassword()) ? GENERIC_SUCCESS_MESSAGE : GENERIC_FAILED_MESSAGE;
        else
            return GENERIC_FAILED_MESSAGE;
    }

}
