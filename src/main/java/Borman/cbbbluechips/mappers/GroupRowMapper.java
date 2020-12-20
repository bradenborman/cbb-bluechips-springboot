package Borman.cbbbluechips.mappers;


import Borman.cbbbluechips.models.usergroups.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GroupRowMapper implements RowMapper<Group> {

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();
        group.setGroupId(rs.getString("Group_ID"));
        group.setGroupName(rs.getString("Group_Name"));
        group.setStartedByUser(rs.getString("Started_By_User"));
        group.setGroupDescription(rs.getString("Group_Description"));
        group.setPassword(rs.getString("Group_Password"));
        group.setPasswordRequiredToJoin(rs.getBoolean("Group_PasswordRequired"));
        return group;
    }

}