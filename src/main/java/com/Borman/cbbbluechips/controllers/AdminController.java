package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.services.AdminService;
import com.Borman.cbbbluechips.services.GameSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    GameSettingsService settingsService;

    @PostMapping("/update-price")
    public String updateMarketPrice(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "nextRoundPrice") double nextRoundPrice, @RequestParam(value = "roundSelector") int roundId) {
        return "redirect:/admin/update/teams";
    }

    @PostMapping("/update-locked")
    public String updateLocked(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "isEliminated", defaultValue = "false") boolean isEliminated,
                                               @RequestParam(value = "isLocked", defaultValue = "false") boolean isLocked) {
        adminService.updateLockedAndEliminated(teamName, isEliminated, isLocked);
        return "redirect:/admin/update/teams";
    }

    @PostMapping("/update-seeds")
    public String updateSeeds(@RequestParam(value = "teamName") String[] teamName, @RequestParam(value = "seed") String[] newSeed) {
        adminService.processUpdateSeedRequest(Arrays.asList(teamName), Arrays.asList(newSeed));
        return "redirect:/admin";
    }

    @PostMapping("/update/current-round")
    public String updateRound(@RequestParam(value = "round") String round) {
        settingsService.updateRound(round);
        return "redirect:/admin";
    }

}

