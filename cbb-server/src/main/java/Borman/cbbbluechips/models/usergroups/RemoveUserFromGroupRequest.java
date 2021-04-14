package Borman.cbbbluechips.models.usergroups;

public class RemoveUserFromGroupRequest {


    private String userId;
    private String groupId;
    private String groupAssocId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupAssocId() {
        return groupAssocId;
    }

    public void setGroupAssocId(String groupAssocId) {
        this.groupAssocId = groupAssocId;
    }

}