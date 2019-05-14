package com.Borman.cbbbluechips.services;

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
    private PortfolioService portfolioService;

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<User> getUsers() {

        logger.info("Getting Users from Database:");
        String sql = "SELECT * FROM heroku_f8c10a0dcaaf757.user;";

        return jdbcTemplate.query(sql ,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rownumber) throws SQLException {
                User user =new User();
                user.setID(rs.getString("User_ID"));
                user.setFirstName(rs.getString("First_Name"));
                user.setLastName(rs.getString("Last_Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                return user;
            }
        });
    }


}