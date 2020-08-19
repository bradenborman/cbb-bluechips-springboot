package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Team;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.models.enums.Ads;
import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.OwnsService;
import com.Borman.cbbbluechips.services.TeamService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketController {

    private TeamService teamService;
    private OwnsService ownsService;
    private boolean shouldDisplayAds;

    public MarketController(CookieService cookieService, TeamService teamService, OwnsService ownsService, @Qualifier("displayAds") boolean shouldDisplayAds) {
        this.teamService = teamService;
        this.ownsService = ownsService;
        this.shouldDisplayAds = shouldDisplayAds;
    }

    @GetMapping("")
    public String market(@RequestParam(defaultValue = "false") String allTeams, Model model, HttpServletRequest request, HttpServletResponse response) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Team> teamsToReturn = allTeams.toLowerCase().equals("true") ? teamService.getAllTeams(false) : teamService.getAllTeams(true);

        //TODO investigate teamUserOwns stored in cookies on login

        ownsService.setTeamsUserOwns(teamsToReturn, user.getID());
        model.addAttribute("teams", teamsToReturn);

        if(shouldDisplayAds)
            model.addAttribute("ads", Ads.getDisplayAdds());

        return "market";
    }

}