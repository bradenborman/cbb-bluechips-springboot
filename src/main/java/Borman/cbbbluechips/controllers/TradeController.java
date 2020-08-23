package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.TradeRequest;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.enums.TradeAction;
import Borman.cbbbluechips.services.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TradeController {

    private TransactionService transactionService;
    private OwnsService ownsService;
    private UserService userService;
    private TeamService teamService;
    private TradeCentralService tradeCentralService;

    public TradeController(TransactionService transactionService, OwnsService ownsService, UserService userService, TeamService teamService, TradeCentralService tradeCentralService) {
        this.transactionService = transactionService;
        this.ownsService = ownsService;
        this.userService = userService;
        this.teamService = teamService;
        this.tradeCentralService = tradeCentralService;
    }

    @RequestMapping("/trade/{team_Id}")
    public String tradeCentral(@PathVariable("team_Id") String teamId, Model model) {
        User user = userService.getUser(getLoggedInUserId());
        model.addAttribute("user", user);
        model.addAttribute("team", teamService.getTeamById(teamId));
        model.addAttribute("details", tradeCentralService.fillTradeCentralDetails(user, teamId));
        return "trade";
    }

    @PostMapping("/trade-action/sell")
    public synchronized String sellTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        User user = userService.getUser(getLoggedInUserId());
        TradeRequest tradeRequest = new TradeRequest(teamId, user.getID(), volume, TradeAction.SELL);
        if (ownsService.validateOwnership(tradeRequest) && teamService.isTeamUnLocked(tradeRequest.getTeamId()))
            transactionService.completeSell(tradeRequest);
        return "redirect:../trade/" + teamId;
    }

    @PostMapping("/trade-action/buy")
    public synchronized String buyTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        User user = userService.getUser(getLoggedInUserId());
        TradeRequest tradeRequest = new TradeRequest(teamId, user.getID(), volume, TradeAction.BUY);
        double fundsAvailable = ownsService.getFundsAvailable(tradeRequest);
        if (teamService.isTeamUnLocked(tradeRequest.getTeamId()))
            transactionService.buyStockInTeam(tradeRequest, fundsAvailable);
        return "redirect:../trade/" + teamId;
    }

    private String getLoggedInUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getID();
    }

}