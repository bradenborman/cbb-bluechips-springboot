package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.mappers.UserRowMapper;
import com.Borman.cbbbluechips.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserDao {

    Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        final String sql = "SELECT * FROM user;";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

}
