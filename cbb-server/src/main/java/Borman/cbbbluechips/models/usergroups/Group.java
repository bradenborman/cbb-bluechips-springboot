package Borman.cbbbluechips.models.usergroups;

public class Group {

    private String groupId;
    private String groupName;
    private String startedByUser;
    private String groupDescription;
    private int numberOfUsersInGroup;
    private String password;
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

    public String getStartedByUser() {
        return startedByUser;
    }

    public void setStartedByUser(String startedByUser) {
        this.startedByUser = startedByUser;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordRequiredToJoin() {
        return passwordRequiredToJoin;
    }

    public void setPasswordRequiredToJoin(boolean passwordRequiredToJoin) {
        this.passwordRequiredToJoin = passwordRequiredToJoin;
    }
}