package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.TradeCentral;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.utilities.UserNameUtility;
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
    public User createNewUser(String fname, String lname, String email_new, String password_new) {

        User user = new User(UserNameUtility.titleCaseConversion(fname), UserNameUtility.titleCaseConversion(lname), email_new, password_new);

        if (!isUserAlreadyPresent(user.getEmail())) {
            user.setCash(STARTING_CASH);
            user.setID(userDao.createNewUser(user));
            return user;
        } else
            logger.info(String.format("%s already in database", user.getEmail()));

        return null;
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

    public User attemptToLogIn(String email, String password) {
        return userDao.loginWithEmailAndPassword(email, password);
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
}