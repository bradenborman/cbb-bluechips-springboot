package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.email.EmailService;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordRecoveringService {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    Logger logger = LoggerFactory.getLogger(PasswordRecoveringService.class);

    private static String GENERIC_SUCCESS_MESSAGE = "An Email containing the password for the requested account has been sent. " +
            "<br /><br />Try searching inbox for: <b>cbb.bluechips.donotreply@gmail.com</b>";

    private static String GENERIC_FAILED_MESSAGE = "Failed to recover password. <br /><br /> Ply try again and validate email.";

    public String getUsersPassword(String emailToRecover) {
        logger.info("Attempting to recover password for: " + emailToRecover);
        User user = userService.getUserByEmail(emailToRecover);

        if(user != null && user.getPassword() != null) {
            emailService.sendPasswordRecoveryEmail(emailToRecover, user.getPassword());
            return GENERIC_SUCCESS_MESSAGE;
        }
        else
            return GENERIC_FAILED_MESSAGE;
    }

}
