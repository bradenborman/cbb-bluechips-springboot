package Borman.cbbbluechips.controllers.admin;

import Borman.cbbbluechips.services.AdminService;
import Borman.cbbbluechips.services.GameSettingsService;
import Borman.cbbbluechips.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    private GameSettingsService settingsService;
    private UserService userService;

    public AdminController(AdminService adminService, GameSettingsService settingsService, UserService userService) {
        this.adminService = adminService;
        this.settingsService = settingsService;
        this.userService = userService;
    }

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
    public String resetGame() {
        settingsService.resetGame();
        return "redirect:/admin";
    }

    @PostMapping("/deletePlayers")
    public String deletePlayers() {
        userService.deleteAllUsers();
        return "redirect:/users/logout";
    }

}