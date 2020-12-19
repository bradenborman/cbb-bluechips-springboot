package Borman.cbbbluechips.daos.sql;

public class GroupSQL {

    public static final String getAllGroups = "SELECT * FROM groups;";

    public static final String getAllGroupsByGroupId = "SELECT * FROM groups WHERE Group_ID = :groupId;";

    public static final String createNewGroup = "INSERT INTO groups (Group_Name, Started_By_User, Group_Description) " +
            "VALUES (:groupName, :userId, :description);";

    public static final String isPasswordCorrect = "SELECT Group_ID FROM groups " +
            "WHERE (group_ID = :groupId) AND (Group_PasswordRequired = 0 OR Group_Password = :password)";


    /*
        USER_GROUP_SQL
     ***************************************************************************/

    public static final String addUserToGroup = "INSERT INTO user_groups (User_ID, Group_ID, Time_Date_Joined) " +
            "VALUES (:groupName, :userId, :timeJoined);";

    public static final String doesUserBelongToGroupAlready = "SELECT Group_Assoc_ID FROM user_groups WHERE User_ID = :userId AND Group_ID = :groupId;";

}