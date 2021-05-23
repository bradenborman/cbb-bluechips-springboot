//package Borman.cbbbluechips.controllers;
//
//import Borman.cbbbluechips.models.usergroups.GroupCreationRequest;
//import Borman.cbbbluechips.services.UserGroupService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/group")
//public class GroupViewController extends ControllerHelper {
//
//    UserGroupService userGroupService;
//
//    public GroupViewController(UserGroupService userGroupService) {
//        this.userGroupService = userGroupService;
//    }
//
//    @GetMapping("/invite/{groupId}/{groupName}")
//    public String acceptInvite(@PathVariable String groupId, @PathVariable String groupName) {
//        userGroupService.userAcceptedGroupInvite(groupId, getLoggedInUserId(), groupName);
//        return "redirect:/leaderboard/group/" + groupId;
//    }
//
//    //Sent as params from form.
//    @PostMapping("/create")
//    public String createGroup(GroupCreationRequest addUserToGroupRequest) {
//        addUserToGroupRequest.setUserIdCreatingGroup(getLoggedInUserId());
//        String createdGroupID = userGroupService.createNewGroup(addUserToGroupRequest);
//        return "redirect:/leaderboard/group/" + createdGroupID;
//    }
//
//}