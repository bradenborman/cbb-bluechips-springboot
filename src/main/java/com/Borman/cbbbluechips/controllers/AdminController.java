package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.Team;
import com.Borman.cbbbluechips.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/sports-data-api/update-teams")
    public ResponseEntity<String> updateSportsDataApiTeamInfo() {
        adminService.updateTeamsStoredInDataBase();
        return ResponseEntity.ok("Updated Teams Wins Losses etc");
    }

    @PostMapping("/update-price")
    public ResponseEntity<String> updateMarketPrice( @RequestParam(value="teamId") String teamId , @RequestParam(value="teamName") String teamName) {
        return ResponseEntity.ok(String.format("Request send to update: %s %s", teamId, teamName));
    }

}
