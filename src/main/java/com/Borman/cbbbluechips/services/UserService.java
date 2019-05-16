package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;


    public List<User> getAllUsers() {
        logger.info("Getting All Users");
        return userDao.getUsers();
    }


    public void createNewUser(User user) {
        logger.info("Prepping to create user: " + user.toString());
    }


}