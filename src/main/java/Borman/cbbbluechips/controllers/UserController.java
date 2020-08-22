package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TransactionService;
import Borman.cbbbluechips.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private OwnsService ownsService;
    private TransactionService transactionService;
    private AuthenticationManager authenticationManager;

    public UserController(AuthenticationManager authenticationManager, UserService userService, OwnsService ownsService, TransactionService transactionService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.ownsService = ownsService;
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public synchronized String createUser(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname,
                             @RequestParam(value = "email_new") String email_new, @RequestParam(value = "password_new") String password_new) {
        String reDirectMessage = userService.createNewUser(fname, lname, email_new, password_new);
        return "redirect:/" + reDirectMessage;
    }

    @PostMapping("/delete")
    String deleteUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        deleteAllTracesFromUser(user.getID());
        return "redirect:../users/logout";
    }

    @Transactional
    private void deleteAllTracesFromUser(String userId) {
        transactionService.deleteUser(userId);
        ownsService.deleteUser(userId);
        userService.deleteUser(userId);
    }

}