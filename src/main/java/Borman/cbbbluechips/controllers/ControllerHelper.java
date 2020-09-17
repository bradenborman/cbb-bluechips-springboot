package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.User;
import org.springframework.security.core.context.SecurityContextHolder;

class ControllerHelper {

    String getLoggedInUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getID();
    }

}