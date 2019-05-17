package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.UserDao;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() { return userDao.getUsers(); }

    @Transactional
    public void createNewUser(User user) {
        user.setCash(100000);
        userDao.createNewUser(user);
    }

    @Transactional
    public void deleteUser(String UserId) {
              userDao.deleteUser(UserId);
    }

}