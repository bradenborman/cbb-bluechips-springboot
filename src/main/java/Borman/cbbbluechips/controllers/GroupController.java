package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.usergroups.AddUserToGroupRequest;
import Borman.cbbbluechips.services.UserGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController extends ControllerHelper {

    UserGroupService userGroupService;

    public GroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @PostMapping("/attempt-to-join")
    public ResponseEntity<String> joinGroup(@RequestBody AddUserToGroupRequest addUserToGroupRequest) {
        addUserToGroupRequest.setUserId(getLoggedInUserId());
        userGroupService.addUserIdToGroup(addUserToGroupRequest);
        return ResponseEntity.ok("Success");
    }

}