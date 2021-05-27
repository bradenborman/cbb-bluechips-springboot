package Borman.cbbbluechips.controllers.api;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.email.EmailService;
import Borman.cbbbluechips.models.paypal.PaypalDonationRequest;
import Borman.cbbbluechips.models.requests.CreateUserRequest;
import Borman.cbbbluechips.models.responses.PhoneNumberDetails;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TransactionService;
import Borman.cbbbluechips.services.UserGroupService;
import Borman.cbbbluechips.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete-user")
    ResponseEntity<Void> deleteUser() {
        String userId = retrieveLoggedInUserId();
        userGroupService.deleteUserFromAllGroups(userId);
        transactionService.deleteUser(userId);
        ownsService.deleteUser(userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user-phone-number-details")
    public ResponseEntity<PhoneNumberDetails> phoneNumberDetails() {
        String userId = retrieveLoggedInUserId();
        return ResponseEntity.ok(userService.retrievePhoneNumberDetails(userId));
    }

    @PostMapping("/update-phone-number")
    public ResponseEntity<Void> updatePhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber) {
        boolean success = userService.updatePhoneNumber(phoneNumber, retrieveLoggedInUserId());
        return success ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    //TODO
    @PostMapping("/update-text-alert-status")
    public ResponseEntity<Void> updateTextAlert(@RequestParam(value = "textStatus") boolean textStatus) {
        userService.toggleTextAlertSubscription(textStatus, retrieveLoggedInUserId());
        return ResponseEntity.ok().build();
    }

    //TODO
    @PostMapping("/paypal-transaction-complete")
    ResponseEntity<Boolean> payEntryFee(@RequestBody PaypalDonationRequest paypalDonationRequest) {
        logger.info("Paid endpoint hit. PayEntryFeeRequest: {}", paypalDonationRequest.toString());
        userService.updatePlayerHasDonated(retrieveLoggedInUserId());
        emailService.sendUpdateEmail(paypalDonationRequest);
        return ResponseEntity.ok(true);
    }


}