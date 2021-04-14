package Borman.cbbbluechips.models.usergroups;

public class UserGroup extends Group {

   private String groupAssocId;
   private String userId;
   private String timeDateJoined;

   private boolean userJoinedGroup;

    public String getGroupAssocId() {
        return groupAssocId;
    }

    public void setGroupAssocId(String groupAssocId) {
        this.groupAssocId = groupAssocId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimeDateJoined() {
        return timeDateJoined;
    }

    public void setTimeDateJoined(String timeDateJoined) {
        this.timeDateJoined = timeDateJoined;
    }

    public boolean isUserJoinedGroup() {
        return userJoinedGroup;
    }

    public void setUserJoinedGroup(boolean userJoinedGroup) {
        this.userJoinedGroup = userJoinedGroup;
    }

}