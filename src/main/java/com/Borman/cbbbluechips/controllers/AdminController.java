package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.services.AdminService;
import com.Borman.cbbbluechips.services.GameSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("/update-price")
    public ResponseEntity<String> updateMarketPrice(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "nextRoundPrice") double nextRoundPrice, @RequestParam(value = "roundSelector") int roundId) {
        return ResponseEntity.ok(String.format("%s %s %s\n\n<a href=\"/admin\">Back to Admin</a>", teamName, nextRoundPrice, roundId));
    }

    @PostMapping("/update-locked")
    public ResponseEntity<String> updateLocked(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "isEliminated", defaultValue = "false") boolean isEliminated,
                                               @RequestParam(value = "isLocked", defaultValue = "false") boolean isLocked) {
        adminService.updateLockedAndEliminated(teamName, isEliminated, isLocked);
        return ResponseEntity.ok("");
    }

    @PostMapping("/update-seeds")
    public ResponseEntity<String> updateSeeds(@RequestParam(value = "teamName") String[] teamName, @RequestParam(value = "seed") String[] newSeed) {
        adminService.processUpdateSeedRequest(Arrays.asList(teamName), Arrays.asList(newSeed));
        return ResponseEntity.ok("OKAY");
    }

}
