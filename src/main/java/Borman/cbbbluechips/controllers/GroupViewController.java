package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.usergroups.GroupCreationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupViewController {

    //Sent as params from form.
    @PostMapping("/create")
    public String createGroup(GroupCreationRequest addUserToGroupRequest) {
        System.out.println("HIT");
        return "redirect:/settings";
    }

}