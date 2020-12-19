package Borman.cbbbluechips.mappers;


import Borman.cbbbluechips.models.usergroups.UserGroup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGroupsRowMapper implements RowMapper<UserGroup> {


    @Override
    public UserGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupAssocId(rs.getString("Group_Assoc_ID"));
        userGroup.setUserId(rs.getString("User_ID"));
        userGroup.setGroupId(rs.getString("Group_ID"));
        userGroup.setTimeDateJoined(rs.getString("Time_Date_Joined"));
        userGroup.setGroupName(rs.getString("Group_Name"));
        userGroup.setStartedByUser(rs.getString("Started_By_User"));
        userGroup.setGroupDescription(rs.getString("Group_Description"));
        userGroup.setPassword(rs.getString("Group_Password"));
        userGroup.setPasswordRequiredToJoin(rs.getBoolean("Group_PasswordRequired"));
        return userGroup;
    }

}