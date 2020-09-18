package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.email.EmailService;
import Borman.cbbbluechips.models.paypal.PayEntryFeeRequest;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TransactionService;
import Borman.cbbbluechips.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    final private Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private EmailService emailService;
    private OwnsService ownsService;
    private TransactionService transactionService;

    public UserController(UserService userService, EmailService emailService, OwnsService ownsService, TransactionService transactionService) {
        this.userService = userService;
        this.emailService = emailService;
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

    //TODO
    @PostMapping("/paypal-transaction-complete")
    ResponseEntity<Boolean> payEntryFee(@RequestBody PayEntryFeeRequest payEntryFeeRequest) {
        logger.info("Paid endpoint hit. PayEntryFeeRequest: {}", payEntryFeeRequest.toString());
        userService.updateHasPlayerPaid(true, getLoggedInUserId());
        emailService.sendUpdateEmail(payEntryFeeRequest);
        return ResponseEntity.ok(true);
    }

    @Transactional
    private void deleteAllTracesFromUser(String userId) {
        transactionService.deleteUser(userId);
        ownsService.deleteUser(userId);
        userService.deleteUser(userId);
    }

}