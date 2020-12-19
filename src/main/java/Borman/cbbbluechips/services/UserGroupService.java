package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.GroupDao;
import Borman.cbbbluechips.models.usergroups.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    //TODO
    public GroupDetails getDetailedGroupsData() {
        GroupDetails details = new GroupDetails();

        UserGroup groups = new UserGroup();
        groups.setGroupId("0");
        groups.setGroupName("Chukar");
        groups.setNumberOfUsersInGroup(12);
        groups.setPasswordRequiredToJoin(false);
        groups.setGroupDescription("Shelter Insurance Dev Team");


        UserGroup group2 = new UserGroup();
        group2.setGroupId("1");
        group2.setGroupName("North Callaway");
        group2.setNumberOfUsersInGroup(15);
        groups.setPasswordRequiredToJoin(true);
        group2.setGroupDescription("Alumni of North Callaway HS");

        details.setUserGroups(Arrays.asList(groups, group2));
        return details;
    }

}