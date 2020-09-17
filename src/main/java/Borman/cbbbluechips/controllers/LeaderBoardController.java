package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.config.Payouts;
import Borman.cbbbluechips.services.LeaderboardService;
import Borman.cbbbluechips.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaderboard")
public class LeaderBoardController extends ControllerHelper {

    private UserService userService;
    private LeaderboardService leaderboardService;
    private Payouts payouts;

    public LeaderBoardController(UserService userService, LeaderboardService leaderboardService, Payouts payouts) {
        this.userService = userService;
        this.leaderboardService = leaderboardService;
        this.payouts = payouts;
    }

    @RequestMapping("")
    public String portfolio(Model model) {
            model.addAttribute("hasUserPayed", userService.hasUserPayed(getLoggedInUserId()));
            model.addAttribute("leaderboard", leaderboardService.getLeaders());
            model.addAttribute("payouts", payouts.getPayoutMap());
            return "leaderboard";
    }

}