package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.GroupDao;
import Borman.cbbbluechips.models.usergroups.*;
import Borman.cbbbluechips.utilities.UserGroupUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {

    Logger logger = LoggerFactory.getLogger(UserGroupService.class);

    GroupDao groupDao;

    public UserGroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    // returns: Generated Primary Key for new Group
    public void createNewGroup(GroupCreationRequest request) {

        //Create new Group in DB
        logger.info("Attempting to create new group: {}", request.getGroupName());
        String createdGroupID = groupDao.createNewGroup(request);

        //Take new Group Id and Add user to associate table
        logger.info("Group added successfully. Adding User to group: {}", request.getUserIdCreatingGroup());
        groupDao.addUserIdToGroup(request.getUserIdCreatingGroup(), createdGroupID);

    }

    public void addUserIdToGroup(AddUserToGroupRequest request) {
        if (isUserMissingAssociation(request.getUserId(), request.getGroupId()) && isPasswordCorrect(request)) {
            groupDao.addUserIdToGroup(request.getUserId(), request.getGroupId());
        }else {
            logger.info("Unable to add user to group.");
        }
    }

    public void removeUserFromGroup(RemoveUserFromGroupRequest request) {
        logger.info("Removing user: {} From Group: {}", request.getUserIdCreatingGroup(), request.getGroupID());
        groupDao.removeUserFromGroup(request);
    }

    private boolean isUserMissingAssociation(String userId, String groupId) {
        boolean doesUserExistAlready = groupDao.doesUserBelongToGroup(userId, groupId);
        logger.info("Checking to see if user already exists with group: {}", doesUserExistAlready);
        return !doesUserExistAlready;
    }

    private boolean isPasswordCorrect(AddUserToGroupRequest request) {
        logger.info("Validating Group Password. Entered: {}", request.getGroupPassword());
        boolean isValid = groupDao.isPasswordCorrect(request);
        logger.info("User has access to group: {}", isValid);
        return isValid;
    }

    public GroupDetails getDetailedGroupsData(String userId) {

        List<UserGroup> joinedGroups = groupDao.getGroupsUserBelongsTo(userId);
        joinedGroups.forEach(userGroup -> userGroup.setUserJoinedGroup(true));

        List<UserGroup> openGroups = groupDao.getOpenGroups(userId);
        openGroups.forEach(userGroup -> userGroup.setUserJoinedGroup(false));

        List<UserGroup> allGroups = UserGroupUtility.combineJoinedAndOpenGroupLists(joinedGroups, openGroups);

        allGroups.forEach(group -> group.setNumberOfUsersInGroup(groupDao.fetchMemberPopulationForGroup(group.getGroupId())));

        GroupDetails details = new GroupDetails();
        details.setUserGroups(allGroups);
        return details;
    }

}