package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.TradeCentral;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ViewController {

    private TradeCentralService tradeCentralService;
    private UserService userService;
    private TeamService teamService;
    private CookieService cookieService;
    private PortfolioService portfolioService;
    private OwnsService ownsService;

    public ViewController(TradeCentralService tradeCentralService, UserService userService, TeamService teamService, CookieService cookieService, PortfolioService portfolioService, OwnsService ownsService) {
        this.tradeCentralService = tradeCentralService;
        this.userService = userService;
        this.teamService = teamService;
        this.cookieService = cookieService;
        this.portfolioService = portfolioService;
        this.ownsService = ownsService;
    }

    @RequestMapping("/")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        return cookieService.isLoggedIn(request) ? "redirect:/portfolio" : "home";
    }

    @RequestMapping("/portfolio")
    public String portfolio(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!cookieService.isLoggedIn(request)) {
            return "redirect:/";
        } else {
            User user = userService.getUser(cookieService.getUserIdLoggedIn(request));
            user.setTeamsOwned(ownsService.getTeamsUserOwns(user.getID()));
            model.addAttribute("user", user);
            model.addAttribute("portfolio", portfolioService.getPortfolioDetails(user));
            return "portfolio";
        }
    }

    @RequestMapping("/market")
    public String market(@RequestParam(defaultValue = "false") String allTeams, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("teams", allTeams.toLowerCase().equals("true") ? teamService.getAllTeams(false) : teamService.getAllTeams(true));
        return "market";
    }

    @RequestMapping("/trade/{team_Id}")
    public String tradeCentral(HttpServletRequest request, @PathVariable("team_Id") String teamId, Model model) {
        if (!cookieService.isLoggedIn(request)) {
            return "redirect:/";
        } else {
                User user = userService.getUser(cookieService.getUserIdLoggedIn(request));
                model.addAttribute("user", user);
                model.addAttribute("team", teamService.getTeamById(teamId));
                model.addAttribute("details", tradeCentralService.fillTradeCentralDetails(user, teamId));
                return "trade";
        }
    }

}
