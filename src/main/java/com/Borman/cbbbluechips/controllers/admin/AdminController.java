package com.Borman.cbbbluechips.controllers.admin;

import com.Borman.cbbbluechips.services.AdminService;
import com.Borman.cbbbluechips.services.CookieService;
import com.Borman.cbbbluechips.services.GameSettingsService;
import com.Borman.cbbbluechips.services.SportsDataApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CookieService cookieService;

    @Autowired
    AdminService adminService;

    @Autowired
    GameSettingsService settingsService;

    @Autowired
    SportsDataApiService sportsDataApiService;

    @PostMapping("/update-price")
    public String updateMarketPrice(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "nextRoundPrice") double nextRoundPrice,
                                    @RequestParam(value = "roundSelector") int roundId) {
        adminService.updateMarketPrice(teamName, nextRoundPrice, roundId);
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


    @PostMapping("/update-pointspread")
    public String updatePointSpread(@RequestParam(value = "teamName") String[] teamName, @RequestParam(value = "nextPointSpread") String[] nextPointSpread) {
        System.out.println("updating " + nextPointSpread.length + " point spreads");
        adminService.processUpdatePointSpreadRequest(Arrays.asList(teamName), Arrays.asList(nextPointSpread));
        return "redirect:/admin";
    }

    @PostMapping("/resetGame")
    public String resetGame(HttpServletRequest request) {
        boolean isAdmin = cookieService.isUserAdmin(request);
        settingsService.resetGame();
        settingsService.updateRound("64");
        return "redirect:/admin";
    }

        //USED FOR TESTING PURPOSES
//    @GetMapping("/update-teamsplaying")
//    public String updateteamsplaying() {
//        sportsDataApiService.updateTeamsPlayingToday();
//        return "test";
//    }

}

