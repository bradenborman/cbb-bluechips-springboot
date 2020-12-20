package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.config.Payouts;
import Borman.cbbbluechips.config.PaypalConfig;
import Borman.cbbbluechips.models.usergroups.Group;
import Borman.cbbbluechips.models.usergroups.UserGroup;
import Borman.cbbbluechips.services.LeaderboardService;
import Borman.cbbbluechips.services.UserGroupService;
import Borman.cbbbluechips.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/leaderboard")
public class LeaderBoardController extends ControllerHelper {

    UserService userService;
    LeaderboardService leaderboardService;
    Payouts payouts;
    PaypalConfig paypalConfig;
    UserGroupService userGroupService;

    public LeaderBoardController(UserService userService, LeaderboardService leaderboardService, Payouts payouts, PaypalConfig paypalConfig, UserGroupService userGroupService) {
        this.userService = userService;
        this.leaderboardService = leaderboardService;
        this.payouts = payouts;
        this.paypalConfig = paypalConfig;
        this.userGroupService = userGroupService;
    }

    @RequestMapping("")
    public String portfolio(Model model) {
        model.addAttribute("hasPayerDonated", userService.hasUserDonated(getLoggedInUserId()));
        model.addAttribute("donationAmount", paypalConfig.getDonationAmount());
        model.addAttribute("leaderboard", leaderboardService.getLeaders());
        model.addAttribute("payouts", payouts.getPayoutMap());
        model.addAttribute("url", paypalConfig.getPayPalUrl());
        return "leaderboard";
    }

    @RequestMapping("/group/{groupId}")
    public String portfolio(@PathVariable String groupId, Model model) {
        String userId = getLoggedInUserId();
//        leaderboardService.fetchLeaderBoardDetailsForGroup();

        Group activeGroup = userGroupService.getGroupDetailById(groupId);
        List<UserGroup> groupsUserOwns = userGroupService.fetchGroupsUserOwns(userId);

        //Filter out group that is currently on display
        List<UserGroup> filtered = groupsUserOwns.stream()
                .filter(group -> !group.getGroupId().equals(groupId))
                .collect(Collectors.toList());

        model.addAttribute("groupName", activeGroup.getGroupName());
        model.addAttribute("usersGroups", filtered);
        return "group-leaderboard";
    }

}