package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class ViewControllerAdmin {

    @Autowired
    TeamService teamService;

    @RequestMapping("")
    public String admin( Model model) {
        model.addAttribute("roundId", "32");
        return "admin_directory";
    }

    @RequestMapping("/update/teams")
    public String updateTeams(@RequestParam(required = false) String teamId, Model model) {
        model.addAttribute("teams", teamService.getAllTeams(true));
        if(teamId != null) {
            System.out.println(String.format("Looking to get Team for updating: %s", teamId));
            model.addAttribute("selectedTeam", teamService.getTeamById(teamId));
        }
        return "team_update";
    }

}

