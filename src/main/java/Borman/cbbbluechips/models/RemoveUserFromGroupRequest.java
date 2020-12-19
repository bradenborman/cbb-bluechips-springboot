package Borman.cbbbluechips.models;

public class RemoveUserFromGroupRequest {


    private String userIdCreatingGroup;
    private String groupID;
    private String groupAssocID;

    public String getUserIdCreatingGroup() {
        return userIdCreatingGroup;
    }

    public void setUserIdCreatingGroup(String userIdCreatingGroup) {
        this.userIdCreatingGroup = userIdCreatingGroup;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupAssocID() {
        return groupAssocID;
    }

    public void setGroupAssocID(String groupAssocID) {
        this.groupAssocID = groupAssocID;
    }

}