package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.mappers.UserRowMapper;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.util.List;

@Component
public class UserDao {

    Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> getUsers() {
        final String sql = "SELECT * FROM user;";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }


    public boolean createNewUser(User user) {

        final String insertUser = "INSERT INTO user (`First_Name`, `Last_Name`, `Email`, `Password`, `Password_Hint`,`Cash`) " +
                "VALUES (:firstName, :lastName, :email, :password, :passwordHint, :cash);";

        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(user);
            if (namedParameterJdbcTemplate.update(insertUser, params) == 1) {
                logger.info("User successfully created");
                return true;
            }
        } catch (Exception e) {
            logger.error("Cannot Insert User" + user + "\n" + e);
        }
        return false;
    }

    public void deleteUser(String userId) {
        final String deleteUser = "DELETE FROM user WHERE User_ID = :userId;";
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            namedParameterJdbcTemplate.update(deleteUser, params);
            logger.info("Deleted User");
        } catch (Exception e) {
            logger.error("Cannot Delete User" + userId + "\n" + e);
        }
    }


}
