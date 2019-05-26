package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.TradeCentral;
import com.Borman.cbbbluechips.models.User;
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
    public void createNewUser(User user) {
        if (!isUserAlreadyPresent(user.getEmail())) {
            user.setCash(STARTING_CASH);
            user.setID(userDao.createNewUser(user));
        } else
            logger.info(String.format("%s already in database", user.getEmail()));
    }

    @Transactional
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

    public User getUser() {
        String UserId = "2";
        return userDao.getUserById(UserId);
    }

}