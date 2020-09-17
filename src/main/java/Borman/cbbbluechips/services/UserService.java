package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.UserDao;
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
    private UserDao userDao;
    private final int STARTING_CASH;

    public UserService(UserDao userDao, @Qualifier("startingCash") final int STARTING_CASH) {
        this.userDao = userDao;
        this.STARTING_CASH = STARTING_CASH;
    }

    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    @Transactional
    public String createNewUser(String fname, String lname, String email_new, String password_new) {
        User user = new User(UserNameUtility.titleCaseConversion(fname), UserNameUtility.titleCaseConversion(lname), email_new, password_new);
        if (!isUserAlreadyPresent(user.getEmail())) {
            user.setCash(STARTING_CASH);
            user.setID(userDao.createNewUser(user));
            return "?newUser=" + user.getEmail();
        } else
            logger.info(String.format("%s already in database", user.getEmail()));
        return "?wasError=true&message=user_already_exists";
    }


    public void deleteUser(String UserId) {
        userDao.deleteUser(UserId);
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
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }

    public User getUser(String id) {
        return userDao.getUserById(id);
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

    public void deleteAllUsers() {
        logger.info("~~ REQUEST TO DELETE ALL PLAYERS ~~");
        getAllUsers().forEach(user -> {
            deleteUser(user.getID());
        });
    }

    public boolean hasUserPayed(String loggedInUserId) {
        logger.info("Checking to see if user {} payed", loggedInUserId);
        return userDao.hasUserPayedEntryFee(loggedInUserId);
    }

    public void updateHasPlayerPaid(boolean hasPlayerPaidEntryFee, String userId) {
        if(hasPlayerPaidEntryFee)
            userDao.updateHasPlayerPaidTrue(userId);
    }

}