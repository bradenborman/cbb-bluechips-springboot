package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.daos.sql.OwnsSQL;
import Borman.cbbbluechips.daos.sql.UserSQL;
import Borman.cbbbluechips.mappers.rowMappers.UserRowMapper;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.exceptions.NoUserPresent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
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

    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> getUsers() {
        return jdbcTemplate.query(UserSQL.getAllUsers, new UserRowMapper());
    }

    public String createNewUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(UserSQL.insertUser, params, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).toString();
    }

    public void deleteUser(String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
        namedParameterJdbcTemplate.update(UserSQL.deleteUser, params);
        logger.info("Deleted User");
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
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("email", email);
        return namedParameterJdbcTemplate.queryForObject(OwnsSQL.countEmailAddress, params, Integer.class);
    }

    public User getUserById(String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
        try {
            return namedParameterJdbcTemplate.queryForObject(UserSQL.getUserById, params, new UserRowMapper());
        } catch (Exception e) {
            throw new NoUserPresent("User ID: " + userId);
        }
    }

    public User loginWithEmailAndPassword(String email, String password) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("email", email)
                    .addValue("password", password);
            return namedParameterJdbcTemplate.queryForObject(UserSQL.getUserWithEmailAndPassword, params, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new NoUserPresent(e.getMessage(), email);
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
        logger.info("UnSubscribed To Text Alerts: " + userId);
        jdbcTemplate.update("UPDATE user SET Send_Alerts = 0 WHERE User_ID = " + userId + ";");
    }

    public String getUserPhoneNumber(String userid) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userid);
        return namedParameterJdbcTemplate.queryForObject(UserSQL.getUserPhoneNumber, params, String.class);
    }

    public void updatePhoneNumber(String phoneNumber, String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("phoneNumber", phoneNumber)
                .addValue("userId", userId);
        namedParameterJdbcTemplate.update(UserSQL.updateUsersPhoneNumber, params);
    }


    public User getUserByEmail(String emailToRecover) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("email", emailToRecover);
            return namedParameterJdbcTemplate.queryForObject(UserSQL.getUserWithEmail, params, new UserRowMapper());
        } catch (Exception e) {
            logger.error("Failed to get User by Email", e);
            return null;
        }
    }

    public boolean hasUserPayedEntryFee(String loggedInUserId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", loggedInUserId);
            return namedParameterJdbcTemplate.queryForObject(UserSQL.hasUserPayed, params, Integer.class) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void updateHasPlayerPaidTrue(String userId) {
        logger.info("Updating user.Payed_Entry_Fee to true");
        jdbcTemplate.update("UPDATE user SET Payed_Entry_Fee = 1 WHERE User_ID = " + userId + ";");
    }

}