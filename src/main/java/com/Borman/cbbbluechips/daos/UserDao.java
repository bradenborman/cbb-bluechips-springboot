package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.UserSQL;
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
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(user);
            return namedParameterJdbcTemplate.update(UserSQL.insertUser, params) == 1;
        } catch (Exception e) {
            logger.error("Cannot Insert User" + user + "\n" + e);
        }
        return false;
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

}
