package Borman.cbbbluechips.models.usergroups;

public class GroupCreationRequest {

    private String userIdCreatingGroup;
    private String groupName;
    private String groupDescription;

    public String getUserIdCreatingGroup() {
        return userIdCreatingGroup;
    }

    public void setUserIdCreatingGroup(String userIdCreatingGroup) {
        this.userIdCreatingGroup = userIdCreatingGroup;
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

}