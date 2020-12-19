package Borman.cbbbluechips.models.usergroups;

public class UserGroup {

    private String groupId;
    private String groupName;
    private String groupDescription;
    private int numberOfUsersInGroup;
    private boolean passwordRequiredToJoin;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public int getNumberOfUsersInGroup() {
        return numberOfUsersInGroup;
    }

    public void setNumberOfUsersInGroup(int numberOfUsersInGroup) {
        this.numberOfUsersInGroup = numberOfUsersInGroup;
    }

    public boolean isPasswordRequiredToJoin() {
        return passwordRequiredToJoin;
    }

    public void setPasswordRequiredToJoin(boolean passwordRequiredToJoin) {
        this.passwordRequiredToJoin = passwordRequiredToJoin;
    }

}