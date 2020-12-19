package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.GroupDao;
import Borman.cbbbluechips.models.GroupCreationRequest;
import Borman.cbbbluechips.models.RemoveUserFromGroupRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        addUserIdToGroup(request.getUserIdCreatingGroup(), createdGroupID);

    }

    public void addUserIdToGroup(String userId, String groupId) {
        if (!doesUserBelongToGroupAlready(userId, groupId))
            groupDao.addUserIdToGroup(userId, groupId);
    }

    public void removeUserFromGroup(RemoveUserFromGroupRequest request) {
        groupDao.removeUserFromGroup(request);
    }

    public boolean doesUserBelongToGroupAlready(String userId, String groupId) {
        boolean doesUserExistAlready = groupDao.doesUserBelongToGroup(userId, groupId);
        logger.info("Checking to see if user already exists with group: {}", doesUserExistAlready);
        return doesUserExistAlready;
    }

}