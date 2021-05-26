package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.UserDao;
import Borman.cbbbluechips.email.EmailService;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.utilities.UserNameUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    UserDao userDao;
    EmailService emailService;
    private final int STARTING_CASH;

    public UserService(UserDao userDao, @Qualifier("startingCash") final int STARTING_CASH, EmailService emailService) {
        this.userDao = userDao;
        this.emailService = emailService;
        this.STARTING_CASH = STARTING_CASH;
    }

    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    @Transactional
    public void createNewUser(String fname, String lname, String email_new, String password_new) {
        User user = new User(UserNameUtility.titleCaseConversion(fname), UserNameUtility.titleCaseConversion(lname), email_new, password_new);
        if (isUserAlreadyPresent(user.getEmail())) {
            logger.info(String.format("%s already in database", user.getEmail()));
        } else {
            user.setCash(STARTING_CASH);
            String userId = userDao.createNewUser(user);
            user.setID(userId);//Do I need to set this still? Investigate
            emailService.sendTermsAndServices(user.getEmail());
        }
    }


    public void deleteUser(String UserId) {
        userDao.deleteUser(UserId);
    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public double getUserCashById(String userId) {
        return getUserById(userId).getCash();
    }

    void addProceedsToUser(String userId, double moneyToAdd) {
        userDao.addCashToUser(userId, moneyToAdd);
    }


    void removeProceedsFromUser(String userId, double moneyToRemove) {
        userDao.removeCashFromUser(userId, moneyToRemove);
    }

    private boolean isUserAlreadyPresent(String email) {
        return userDao.countEmailAddressInDatabase(email) > 0;
    }

    String getUserFullName(String userId) {
        User user = userDao.getUserById(userId);
        return user != null ? String.format("%s %s", user.getFirstName(), user.getLastName()) : "No User Found.";
    }

    public User retrieveUserById(String id) {
        return userDao.retrieveUserById(id);
    }

    public String retrieveUserEmailById(String id) {
        return userDao.retrieveUserById(id).getEmail();
    }

    public boolean doesUserSubscribeToTextAlerts(String userId) {
        return userDao.doesUserSubscribeToTextAlerts(userId);
    }

    public void toggleTextAlertSubscription(boolean textStatus, String userIdLoggedIn) {
        if (textStatus)
            userDao.subscribeUserToTextAlerts(userIdLoggedIn);
        else
            userDao.unSubscribeUserToTextAlerts(userIdLoggedIn);
    }

    public void updatePhoneNumber(String phoneNumber, String UserId) {
        logger.info(String.format("Request to change Phone Number: %s by user: %s", phoneNumber, UserId));
        userDao.updatePhoneNumber(phoneNumber, UserId);
        if ("".equals(phoneNumber))
            userDao.unSubscribeUserToTextAlerts(UserId);

    }

    public String getUserPhoneNumber(String userid) {
        return userDao.getUserPhoneNumber(userid);
    }

    public User getUserByEmail(String emailToRecover) {
        return userDao.getUserByEmail(emailToRecover);
    }

    public boolean hasUserDonated(String loggedInUserId) {
        logger.info("Checking to see if user {} donated", loggedInUserId);
        return userDao.hasUserDonated(loggedInUserId);
    }

    public void updatePlayerHasDonated(String userId) {
        logger.info("Awarding $50,000 to user: {}", userId);
        userDao.addCashToUser(userId, 50000);
        userDao.updateHasPlayerPaidTrue(userId);
    }

}