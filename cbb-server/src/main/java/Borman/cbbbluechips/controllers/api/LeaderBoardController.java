package Borman.cbbbluechips.controllers.api;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.models.LeaderBoardUser;
import Borman.cbbbluechips.services.LeaderboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class LeaderBoardController extends AuthenticatedController {

    LeaderboardService leaderboardService;

    public LeaderBoardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<LeaderBoardUser>> leaderboard() {
        return ResponseEntity.ok(leaderboardService.getLeaders());
    }

//    @Deprecated
//    @RequestMapping("/group/{groupId}")
//    public String portfolio(@PathVariable String groupId, Model model) {
//        String userId = getLoggedInUserId();
//
//        String[] activeEnv = environment.getActiveProfiles();
//
//        Group activeGroup = userGroupService.getGroupDetailById(groupId);
//        List<UserGroup> groupsUserOwns = userGroupService.fetchGroupsUserOwns(userId);
//
//        //Filter out group that is currently on display
//        List<UserGroup> filtered = groupsUserOwns.stream()
//                .filter(group -> !group.getGroupId().equals(groupId))
//                .collect(Collectors.toList());
//        model.addAttribute("leaderboard", leaderboardService.fetchLeaderBoardDetailsForGroup(groupId));
//        model.addAttribute("groupName", activeGroup.getGroupName());
//        model.addAttribute("groupDescription", activeGroup.getGroupDescription());
//        model.addAttribute("inviteLink", UserGroupUtility.buildInviteLink(activeGroup, activeEnv));
//        model.addAttribute("usersGroups", filtered);
//        return "group-leaderboard";
//    }

}