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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ViewController {

    private TradeCentralService tradeCentralService;
    private UserService userService;
    private TeamService teamService ;
    private CookieService cookieService;

    public ViewController(TradeCentralService tradeCentralService, UserService userService, TeamService teamService, CookieService cookieService) {
        this.tradeCentralService = tradeCentralService;
        this.userService = userService;
        this.teamService = teamService;
        this.cookieService = cookieService;
    }

    @RequestMapping("/")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        return cookieService.isLoggedIn(request) ? "redirect:/portfolio" : "home";
    }

    @RequestMapping("/portfolio")
    public String portfolio(Model model, HttpServletRequest request, HttpServletResponse response) {
       return cookieService.isLoggedIn(request) ? "portfolio" : "redirect:/";
    }

    @RequestMapping("/market")
    public String market(@RequestParam(defaultValue = "false") String allTeams, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("teams", allTeams.toLowerCase().equals("true") ? teamService.getAllTeams(false) : teamService.getAllTeams(true));
        return "market";
    }

    @RequestMapping("/trade/{team_Id}")
    public String tradeCentral(@PathVariable("team_Id") String teamId, Model model) {
        User user = userService.getUser();
        model.addAttribute("user", user);
        model.addAttribute("team", teamService.getTeamById(teamId));
        model.addAttribute("details", tradeCentralService.fillTradeCentralDetails(user, teamId));
        return "trade";
    }


}
