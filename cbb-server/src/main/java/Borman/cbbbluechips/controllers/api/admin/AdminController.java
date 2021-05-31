package Borman.cbbbluechips.controllers.api.admin;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.models.Team;
import Borman.cbbbluechips.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class AdminController extends AuthenticatedController {

    AdminService adminService;
    GameSettingsService settingsService;
    UserService userService;
    UserGroupService userGroupService;
    TransactionService transactionService;
    OwnsService ownsService;
    TeamService teamService;

    public AdminController(AdminService adminService, GameSettingsService settingsService,
                           UserService userService, UserGroupService userGroupService,
                           TransactionService transactionService, OwnsService ownsService, TeamService teamService) {
        this.adminService = adminService;
        this.settingsService = settingsService;
        this.userService = userService;
        this.userGroupService = userGroupService;
        this.transactionService = transactionService;
        this.ownsService = ownsService;
        this.teamService = teamService;
    }

    @GetMapping("/role-check")
    public ResponseEntity<Boolean> adminRoleCheck() {
        boolean isAdmin = retrieveLoggedInUser().getAuthorities()
                .stream().anyMatch(x -> x.getAuthority().equals("CBB_ADMIN"));
        return ResponseEntity.ok(isAdmin);
    }

    @GetMapping("/all-teams")
    public ResponseEntity<List<Team>> allTeams() {
       return ResponseEntity.ok(teamService.getAllTeams(false));
    }

//    @PostMapping("/update-price")
//    public String updateMarketPrice(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "nextRoundPrice") double nextRoundPrice,
//                                    @RequestParam(value = "roundSelector") int roundId,
//                                    @RequestParam(value = "teamId") int teamId) {
//        adminService.updateMarketPrice(teamName, nextRoundPrice, roundId);
//        return "redirect:/admin/update/teams?teamId=" + teamId;
//    }
//
//    @PostMapping("/update-locked")
//    public String updateLocked(@RequestParam(value = "teamName") String teamName, @RequestParam(value = "isEliminated", defaultValue = "false") boolean isEliminated,
//                               @RequestParam(value = "isLocked", defaultValue = "false") boolean isLocked) {
//        adminService.updateLockedAndEliminated(teamName, isEliminated, isLocked);
//        return "redirect:/admin/update/teams";
//    }
//
//    @PostMapping("/update-seeds")
//    public String updateSeeds(@RequestParam(value = "teamName") String[] teamName, @RequestParam(value = "seed") String[] newSeed) {
//        adminService.processUpdateSeedRequest(Arrays.asList(teamName), Arrays.asList(newSeed));
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/update/current-round")
//    public String updateRound(@RequestParam(value = "round") String round) {
//        settingsService.updateRound(round);
//        return "redirect:/admin";
//    }
//
//
//    @PostMapping("/update-pointspread")
//    public String updatePointSpread(@RequestParam(value = "teamName") String[] teamName, @RequestParam(value = "nextPointSpread") String[] nextPointSpread) {
//        adminService.processUpdatePointSpreadRequest(Arrays.asList(teamName), Arrays.asList(nextPointSpread));
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/delete-group")
//    public ResponseEntity<String> deleteGroup(@RequestBody DeleteGroupRequest deleteGroupRequest) {
//        userGroupService.deleteGroup(deleteGroupRequest.getGroupId());
//        return ResponseEntity.ok().build();
//    }

//    @PostMapping("/resetGame")
//    public String resetGame() {
//        settingsService.resetGame();
//        return "redirect:/admin";
//    }

//    //TODO clean up -- dont use where cluse --> just delete whole table data
//    @PostMapping("/deletePlayers")
//    public String deletePlayers() {
//        userService.getAllUsers().forEach(user -> {
//            System.out.println("Deleting all items for user: " + user.getID());
//            userGroupService.deleteUserFromAllGroups(user.getID());
//            transactionService.deleteUser(user.getID());
//            ownsService.deleteUser(user.getID());
//            userService.deleteUser(user.getID());
//        });
//
//        return "redirect:/users/logout";
//    }

}