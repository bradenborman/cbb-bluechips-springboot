package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.services.LeaderboardService;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.PortfolioService;
import Borman.cbbbluechips.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    private UserService userService;
    private OwnsService ownsService;
    private PortfolioService portfolioService;
    private LeaderboardService leaderboardService;

    public PortfolioController(UserService userService, OwnsService ownsService, PortfolioService portfolioService, LeaderboardService leaderboardService) {
        this.userService = userService;
        this.ownsService = ownsService;
        this.portfolioService = portfolioService;
        this.leaderboardService = leaderboardService;
    }

    @RequestMapping("")
    public String portfolio(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setTeamsOwned(ownsService.getTeamsUserOwns(user.getID()));
        model.addAttribute("user", user);
        model.addAttribute("leaderBoardPos", leaderboardService.getUsersLeaderPosition(userService.getUser(user.getID())));
        model.addAttribute("portfolio", portfolioService.getPortfolioDetails(user));
        return "portfolio";
    }

}
