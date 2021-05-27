package Borman.cbbbluechips.controllers.api;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.email.EmailService;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.paypal.PaypalDonationRequest;
import Borman.cbbbluechips.models.requests.CreateUserRequest;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TransactionService;
import Borman.cbbbluechips.services.UserGroupService;
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

@Controller
@RequestMapping("/api")
public class UserController extends AuthenticatedController {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    UserService userService;
    EmailService emailService;
    OwnsService ownsService;
    TransactionService transactionService;
    UserGroupService userGroupService;

    public UserController(UserService userService, EmailService emailService, OwnsService ownsService,
                          TransactionService transactionService, UserGroupService userGroupService) {
        this.userService = userService;
        this.emailService = emailService;
        this.ownsService = ownsService;
        this.transactionService = transactionService;
        this.userGroupService = userGroupService;
    }

    @PostMapping("/create-user")
    public synchronized ResponseEntity<Void> createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return ResponseEntity.ok().build();
    }

    //TODO
    @PostMapping("/delete")
    String deleteUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        deleteAllTracesFromUser(user.getID());
        return "redirect:../users/logout";
    }

    //TODO
    @PostMapping("/paypal-transaction-complete")
    ResponseEntity<Boolean> payEntryFee(@RequestBody PaypalDonationRequest paypalDonationRequest) {
        logger.info("Paid endpoint hit. PayEntryFeeRequest: {}", paypalDonationRequest.toString());
        userService.updatePlayerHasDonated(retrieveLoggedInUserId());
        emailService.sendUpdateEmail(paypalDonationRequest);
        return ResponseEntity.ok(true);
    }

    //TODO
    @Transactional
    private void deleteAllTracesFromUser(String userId) {
        userGroupService.deleteUserFromAllGroups(userId);
        transactionService.deleteUser(userId);
        ownsService.deleteUser(userId);
        userService.deleteUser(userId);
    }

}