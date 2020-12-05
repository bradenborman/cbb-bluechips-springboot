package Borman.cbbbluechips.controllers.admin;

import Borman.cbbbluechips.services.GameSettingsService;
import Borman.cbbbluechips.services.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class ViewControllerAdmin {

    private Logger logger = LoggerFactory.getLogger(ViewControllerAdmin.class);

    private TeamService teamService;
    private GameSettingsService gameSettingsService;

    public ViewControllerAdmin(TeamService teamService, GameSettingsService gameSettingsService) {
        this.teamService = teamService;
        this.gameSettingsService = gameSettingsService;
    }

    @RequestMapping("")
    public String admin(Model model) {
        model.addAttribute("roundId", gameSettingsService.getCurrentRound());
        return "admin_directory";
    }

    @RequestMapping("/update/teams")
    public String updateTeams(@RequestParam(required = false) String teamId, Model model) {
        model.addAttribute("teams", teamService.getAllTeams(true));
        model.addAttribute("currentRound", gameSettingsService.getCurrentRound());
        if(teamId != null) {
            logger.info("Looking to get Team for updating: {}", teamId);
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
    public String setPointSpread(Model model) {
        model.addAttribute("teams", gameSettingsService.getTeamsPlayingTodayWithNoPointSpreadSet());
        return "set_pointspread";
    }

    @RequestMapping("/test-paypal")
    public String test() {
        return "test-paypal";
    }

}