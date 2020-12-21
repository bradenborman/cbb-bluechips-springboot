package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.usergroups.GroupCreationRequest;
import Borman.cbbbluechips.services.UserGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupViewController extends ControllerHelper {

    UserGroupService userGroupService;

    public GroupViewController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    //Sent as params from form.
    @PostMapping("/create")
    public String createGroup(GroupCreationRequest addUserToGroupRequest) {
        addUserToGroupRequest.setUserIdCreatingGroup(getLoggedInUserId());
        String createdGroupID = userGroupService.createNewGroup(addUserToGroupRequest);
        return "redirect:/leaderboard/group/" + createdGroupID;
    }

}