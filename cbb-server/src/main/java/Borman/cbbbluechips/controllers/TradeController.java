package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.builders.TeamExchangeDetailsResponseBuilder;
import Borman.cbbbluechips.models.Owns;
import Borman.cbbbluechips.models.Team;
import Borman.cbbbluechips.models.TradeRequest;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.enums.TradeAction;
import Borman.cbbbluechips.models.responses.TeamExchangeDetailsResponse;
import Borman.cbbbluechips.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TradeController extends ControllerHelper {

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
        User user = userService.getUserLoggedIn(getLoggedInUserId());
        model.addAttribute("user", user);
        model.addAttribute("team", teamService.getTeamById(teamId));
        model.addAttribute("details", tradeCentralService.fillTradeCentralDetails(user, teamId));
        return "trade";
    }

    @PostMapping("/trade-action/sell")
    public synchronized String sellTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        User user = userService.getUserLoggedIn(getLoggedInUserId());
        TradeRequest tradeRequest = new TradeRequest(teamId, user.getID(), volume, TradeAction.SELL);
        if (ownsService.validateOwnership(tradeRequest) && teamService.isTeamUnLocked(tradeRequest.getTeamId()))
            transactionService.completeSell(tradeRequest);
        return "redirect:../trade/" + teamId;
    }

    @PostMapping("/trade-action/buy")
    public synchronized String buyTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        User user = userService.getUserLoggedIn(getLoggedInUserId());
        TradeRequest tradeRequest = new TradeRequest(teamId, user.getID(), volume, TradeAction.BUY);
        double fundsAvailable = ownsService.getFundsAvailable(tradeRequest);
        if (teamService.isTeamUnLocked(tradeRequest.getTeamId()))
            transactionService.buyStockInTeam(tradeRequest, fundsAvailable);
        return "redirect:../trade/" + teamId;
    }

    //note: Concerns include selling teams that are already sold in another tab or buying too much same way.. by selling/buying alt way
    @PostMapping("/trade/sell-all")
    public synchronized ResponseEntity<String> sellAllInUsersPortfolio() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Owns> owns = ownsService.getTeamsUserOwns(user.getID());
        owns.forEach(team -> {
            TradeRequest tradeRequest = new TradeRequest(team.getTeamId(), user.getID(), team.getAmountOwned(), TradeAction.SELL);
            if (ownsService.validateOwnership(tradeRequest) && teamService.isTeamUnLocked(tradeRequest.getTeamId()))
                transactionService.completeSell(tradeRequest);
        });
        return ResponseEntity.ok("OKAY");
    }





    /*
            Endpoints for react views
     */

    @RequestMapping("api/exchange-details/{team_Id}")
    public ResponseEntity<TeamExchangeDetailsResponse> getTeamDataForTrading(@PathVariable("team_Id") String teamId) {

        String userId = getLoggedInUserId();

        User user = userService.getUserLoggedIn(userId);
        Team team = teamService.getTeamById(teamId);

        TeamExchangeDetailsResponse teamExchangeDetailsResponse = TeamExchangeDetailsResponseBuilder.aTeamExchangeDetailsResponse()
                .populateWithUser(user)
                .populatWithTeam(team)
                .build();

        tradeCentralService.fillExchangeDetails(teamExchangeDetailsResponse);

        return ResponseEntity.ok(teamExchangeDetailsResponse);
    }


}