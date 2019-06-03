package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.OwnsSQL;
import com.Borman.cbbbluechips.daos.sql.UserSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.UserRowMapper;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserDao {

    Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> getUsers() {
        return jdbcTemplate.query(UserSQL.getAllUsers, new UserRowMapper());
    }

    public String createNewUser(User user) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            SqlParameterSource params = new BeanPropertySqlParameterSource(user);
            namedParameterJdbcTemplate.update(UserSQL.insertUser, params, keyHolder);
            return Objects.requireNonNull(keyHolder.getKey()).toString();
        } catch (Exception e) {
            logger.error("Cannot Insert User" + user + "\n" + e);
            return "0";
        }
    }

    public void deleteUser(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            namedParameterJdbcTemplate.update(UserSQL.deleteUser, params);
            logger.info("Deleted User");
        } catch (Exception e) {
            logger.error("Cannot Delete User" + userId + "\n" + e);
        }
    }

    public void addCashToUser(String userId, double moneyToAdd) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("newMoney", moneyToAdd);
        namedParameterJdbcTemplate.update(UserSQL.addMoneyToUser, params);
    }


    public void removeCashFromUser(String userId, double moneyToRemove) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("newMoney", moneyToRemove);
        namedParameterJdbcTemplate.update(UserSQL.removeMoneyFromUser, params);
    }

    public int countEmailAddressInDatabase(String email) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("email", email);
            return namedParameterJdbcTemplate.queryForObject(OwnsSQL.countEmailAddress, params, Integer.class);
        } catch (Exception e) {
            logger.error("Failed to get User by Email\n" + e);
        }
        return 0;
    }

    public User getUserById(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.queryForObject(UserSQL.getUserById, params, new UserRowMapper());
        } catch (Exception e) {
            logger.error("Failed to get User by Email\n" + e);
            return null;
        }
    }

    public User loginWithEmailAndPassword(String email, String password) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("email", email)
                    .addValue("password", password);
            return namedParameterJdbcTemplate.queryForObject(UserSQL.getUserWithEmailAndPassword, params, new UserRowMapper());
        } catch (Exception e) {
            logger.error("Failed to get User by Email\n" + e);
            return null;
        }
    }


    public boolean doesUserSubscribeToTextAlerts(String userId) {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.queryForObject(UserSQL.doesUserSubscribeToTextAlerts, params, Integer.class) > 0;
    }

    public void subscribeUserToTextAlerts(String userId) {
        jdbcTemplate.update("UPDATE user SET Send_Alerts = 1 WHERE User_ID = " + userId + ";");
    }

    public void unSubscribeUserToTextAlerts(String userId) {
        jdbcTemplate.update("UPDATE user SET Send_Alerts = 0 WHERE User_ID = " + userId + ";");
    }

}
