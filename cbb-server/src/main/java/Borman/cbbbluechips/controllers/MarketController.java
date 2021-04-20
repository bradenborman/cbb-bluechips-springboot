package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.Team;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.enums.Ads;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TeamService;
import Borman.cbbbluechips.utilities.JumpMenuList;
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

    public MarketController(TeamService teamService, OwnsService ownsService, @Qualifier("displayAds") boolean shouldDisplayAds) {
        this.teamService = teamService;
        this.ownsService = ownsService;
        this.shouldDisplayAds = shouldDisplayAds;
    }

//    @GetMapping("")
//    public String market(@RequestParam(defaultValue = "false") String allTeams, Model model, HttpServletRequest request, HttpServletResponse response) {
//        List<Team> teamsToReturn =  teamService.getAllTeams(!allTeams.toLowerCase().equals("true"));
//        ownsService.setTeamsUserOwns(teamsToReturn, getLoggedInUser().getID());
//        model.addAttribute("teams", teamsToReturn);
//        model.addAttribute("jumpMenu", JumpMenuList.buildQuickJumpList(teamsToReturn));
//        if(shouldDisplayAds)
//            model.addAttribute("ads", Ads.getDisplayAdds());
//        return "market";
//    }

    private User getLoggedInUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}