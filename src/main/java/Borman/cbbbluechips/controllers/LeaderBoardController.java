package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.config.Payouts;
import Borman.cbbbluechips.config.PaypalConfig;
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
    private PaypalConfig paypalConfig;

    public LeaderBoardController(UserService userService, LeaderboardService leaderboardService, Payouts payouts, PaypalConfig paypalConfig) {
        this.userService = userService;
        this.leaderboardService = leaderboardService;
        this.payouts = payouts;
        this.paypalConfig = paypalConfig;
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

}