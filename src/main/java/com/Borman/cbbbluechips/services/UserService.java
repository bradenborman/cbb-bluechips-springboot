package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private PortfolioService portfolioService;

    public List<User> getUsers() {

        List<User> allUsers = new ArrayList<User>();

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