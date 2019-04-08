package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private PortfolioService portfolioService;

    public List<User> getUsers() {

        logger.info("Getting Users");

        List<User> allUsers = new ArrayList<>();

        User user = new User();
        user.setFirstName("Braden");
        user.setLastName("Borman");
        user.setEmail("bradenborman@hotmail.com");
        user.setPassword("password");
        user.setPasswordHint("passwordhint");
        allUsers.add(user);

        User user2 = new User();
        user2.setFirstName("Brent");
        user2.setLastName("Thoenen");
        user2.setEmail("btd_thoenen@hotmail.com");
        user2.setPassword("yeet");
        user2.setPasswordHint("rhymes with skeet");
        user2.setPortfolio(portfolioService.getPortfolio());
        allUsers.add(user2);

        return allUsers;
    }


}