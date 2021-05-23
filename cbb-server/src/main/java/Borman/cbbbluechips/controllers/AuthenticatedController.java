package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AuthenticatedController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedController.class);

    protected String retrieveLoggedInUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("User {} logged in", user.getID());
        return user.getID();
    }

    protected User retrieveLoggedInUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}