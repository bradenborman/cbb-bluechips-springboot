package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.email.EmailService;
import Borman.cbbbluechips.models.paypal.PaypalDonationRequest;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TransactionService;
import Borman.cbbbluechips.services.UserGroupService;
import Borman.cbbbluechips.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController extends ControllerHelper {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    UserService userService;
    EmailService emailService;
    OwnsService ownsService;
    TransactionService transactionService;
    UserGroupService userGroupService;
    boolean usersAllowedToSignUp;

    public UserController(UserService userService, EmailService emailService, OwnsService ownsService,
                          TransactionService transactionService, UserGroupService userGroupService, @Qualifier("signUpAllowed") boolean signUpAllowed) {
        this.userService = userService;
        this.emailService = emailService;
        this.ownsService = ownsService;
        this.transactionService = transactionService;
        this.userGroupService = userGroupService;
        this.usersAllowedToSignUp = signUpAllowed;
    }

    @PostMapping("/create")
    public synchronized String createUser(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname,
                             @RequestParam(value = "email_new") String email_new, @RequestParam(value = "password_new") String password_new) {
        String reDirectMessage = "home?signUpClosed=true";
        if(usersAllowedToSignUp)
            reDirectMessage = userService.createNewUser(fname, lname, email_new, password_new);

        return "redirect:/" + reDirectMessage;
    }

    @PostMapping("/delete")
    String deleteUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        deleteAllTracesFromUser(user.getID());
        return "redirect:../users/logout";
    }

    @PostMapping("/paypal-transaction-complete")
    ResponseEntity<Boolean> payEntryFee(@RequestBody PaypalDonationRequest paypalDonationRequest) {
        logger.info("Paid endpoint hit. PayEntryFeeRequest: {}", paypalDonationRequest.toString());
        userService.updatePlayerHasDonated(getLoggedInUserId());
        emailService.sendUpdateEmail(paypalDonationRequest);
        return ResponseEntity.ok(true);
    }

    @Transactional
    private void deleteAllTracesFromUser(String userId) {
        userGroupService.deleteUserFromAllGroups(userId);
        transactionService.deleteUser(userId);
        ownsService.deleteUser(userId);
        userService.deleteUser(userId);
    }

}