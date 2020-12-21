package Borman.cbbbluechips.daos.sql;

public class GroupSQL {

    public static final String getGroupDetailById = "SELECT * FROM groups WHERE Group_ID = :groupId;";

    public static final String createNewGroup = "INSERT INTO groups (Group_Name, Started_By_User, Group_Description, Group_Password, Group_PasswordRequired) " +
            "VALUES (:groupName, :userId, :description, :password, :passwordRequired);";

    public static final String isPasswordCorrect = "SELECT Group_ID FROM groups " +
            "WHERE (group_ID = :groupId) AND (Group_PasswordRequired = 0 OR Group_Password = :password)";


    /*
        USER_GROUP_SQL
     ***************************************************************************/

    public static final String addUserToGroup = "INSERT INTO user_groups (User_ID, Group_ID, Time_Date_Joined) " +
            "VALUES (:userId, :groupId, :timeJoined);";

    public static final String doesUserBelongToGroupAlready = "SELECT Group_Assoc_ID FROM user_groups WHERE User_ID = :userId AND Group_ID = :groupId;";

    public static final String getGroupsUserBelongsTo = "SELECT Group_Assoc_ID, User_ID, Time_Date_Joined, user_groups.Group_ID, Group_Name, " +
            "Started_By_User, Group_Description, Group_Password, Group_PasswordRequired " +
            "FROM user_groups " +
            "JOIN groups ON groups.Group_ID = user_groups.Group_ID " +
            "WHERE User_ID = :userId";

    public static final String getGroupsUserDoesNotBelongsTo = "SELECT * FROM groups " +
            "WHERE Group_ID " +
            "not in (SELECT Group_ID from user_groups WHERE user_groups.User_ID = :userId)";


    public static final String fetchMemberPopulationForGroup  = "SELECT count(Group_ID) as count FROM user_groups Where Group_ID = :groupId";

    public static final String removeUserFromGroup  = "DELETE from user_groups WHERE Group_Assoc_ID = :assocId AND Group_ID = :groupId AND User_ID = :userId";

    public static final String deleteUserFromAllGroups = "DELETE from user_groups WHERE User_ID = :userId";


    /*
        User SQL
     ****************************************************************************/

    public static final String getUsersInGroup = "SELECT * FROM user " +
            "WHERE User_ID in (SELECT User_ID FROM user_groups WHERE Group_ID = :groupId)";

}