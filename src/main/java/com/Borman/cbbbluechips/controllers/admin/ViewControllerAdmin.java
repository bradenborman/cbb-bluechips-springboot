package com.Borman.cbbbluechips.controllers.admin;

import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.GameSettingsService;
import com.Borman.cbbbluechips.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/admin")
public class ViewControllerAdmin {

    @Autowired
    TeamService teamService;

    @Autowired
    GameSettingsService gameSettingsService;

    @Autowired
    CookieService cookieService;

    @RequestMapping("")
    public String admin(HttpServletRequest request, Model model) {
        boolean isAdmin = cookieService.isUserAdmin(request);
       if(!isAdmin)
           return "redirect:/";
        //System.out.println(String.format("IS ADMIN: %s", isAdmin));
        model.addAttribute("roundId", gameSettingsService.getCurrentRound());
        return "admin_directory";
    }


    @RequestMapping("/update/teams")
    public String updateTeams(@RequestParam(required = false) String teamId, Model model) {
        model.addAttribute("teams", teamService.getAllTeams(true));
        model.addAttribute("currentRound", gameSettingsService.getCurrentRound());
        if(teamId != null) {
            System.out.println(String.format("Looking to get Team for updating: %s", teamId));
            model.addAttribute("selectedTeam", teamService.getTeamById(teamId));
        }
        return "team_update";
    }

    @RequestMapping("/set/seeds")
    public String setSeeds(Model model) {
        model.addAttribute("allTeams", teamService.getAllTeams(false));
        return "set_seeds";
    }

    @RequestMapping("/set/round")
    public String setRound(Model model) {
        model.addAttribute("currentRound", gameSettingsService.getCurrentRound());
        return "set_round";
    }

    @RequestMapping("/set/pointspread")
    public String setPointspread(Model model) {
        model.addAttribute("teams", gameSettingsService.getTeamsPlayingTodayWithNoPointSpreadSet());
        return "set_pointspread";
    }


}

