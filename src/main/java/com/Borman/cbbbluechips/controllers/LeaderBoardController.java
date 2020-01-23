package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.config.Payouts;
import com.Borman.cbbbluechips.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/leaderboard")
public class LeaderBoardController {

    @Autowired
    LeaderboardService leaderboardService;

    @Autowired
    Payouts payouts;


    @RequestMapping("")
    public String portfolio(Model model, Authentication authentication, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");
        System.out.println(String.format("USER %s is logged in with spring security", user_id));
        model.addAttribute("leaderboard", leaderboardService.getLeaders());
        model.addAttribute("payouts", payouts.getPayoutMap());
        return "leaderboard";
    }

}
