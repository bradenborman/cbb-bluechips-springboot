package com.Borman.cbbbluechips.mappers;

import com.Borman.cbbbluechips.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

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
}
