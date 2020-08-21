package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.config.Payouts;
import com.Borman.cbbbluechips.services.LeaderboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaderboard")
public class LeaderBoardController {

    private LeaderboardService leaderboardService;
    private Payouts payouts;

    public LeaderBoardController(LeaderboardService leaderboardService, Payouts payouts) {
        this.leaderboardService = leaderboardService;
        this.payouts = payouts;
    }

    @RequestMapping("")
    public String portfolio(Model model) {
            model.addAttribute("leaderboard", leaderboardService.getLeaders());
            model.addAttribute("payouts", payouts.getPayoutMap());
            return "leaderboard";
    }

}
