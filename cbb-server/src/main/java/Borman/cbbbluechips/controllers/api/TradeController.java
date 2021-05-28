package Borman.cbbbluechips.controllers.api;

import Borman.cbbbluechips.controllers.AuthenticatedController;
import Borman.cbbbluechips.models.responses.TeamExchangeDetailsResponse;
import Borman.cbbbluechips.services.TradeCentralService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TradeController extends AuthenticatedController {

    TradeCentralService tradeCentralService;

    public TradeController(TradeCentralService tradeCentralService) {

        this.tradeCentralService = tradeCentralService;
    }


    @GetMapping("/exchange-details/{team_Id}")
    public ResponseEntity<TeamExchangeDetailsResponse> teamExchangeDetailsResponse(@PathVariable("team_Id") String teamId) {
        String userId = retrieveLoggedInUserId();
        return ResponseEntity.ok(tradeCentralService.fillExchangeDetails(userId, teamId));
    }


//    //TODO verify
//    @RequestMapping("/trade/{team_Id}")
//    public String tradeCentral(@PathVariable("team_Id") String teamId, Model model) {
//        User user = userService.getUserLoggedIn(getLoggedInUserId());
//        model.addAttribute("user", user);
//        model.addAttribute("team", teamService.getTeamById(teamId));
//        model.addAttribute("details", tradeCentralService.fillTradeCentralDetails(user, teamId));
//        return "trade";
//    }
//
//    //TODO verify
//    @PostMapping("/trade-action/sell")
//    public synchronized String sellTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
//        User user = userService.getUserLoggedIn(getLoggedInUserId());
//        TradeRequest tradeRequest = new TradeRequest(teamId, user.getID(), volume, TradeAction.SELL);
//        if (ownsService.validateOwnership(tradeRequest) && teamService.isTeamUnLocked(tradeRequest.getTeamId()))
//            transactionService.completeSell(tradeRequest);
//        return "redirect:../trade/" + teamId;
//    }
//
//    //TODO verify
//    @PostMapping("/trade-action/buy")
//    public synchronized String buyTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
//        User user = userService.getUserLoggedIn(getLoggedInUserId());
//        TradeRequest tradeRequest = new TradeRequest(teamId, user.getID(), volume, TradeAction.BUY);
//        double fundsAvailable = ownsService.getFundsAvailable(tradeRequest);
//        if (teamService.isTeamUnLocked(tradeRequest.getTeamId()))
//            transactionService.buyStockInTeam(tradeRequest, fundsAvailable);
//        return "redirect:../trade/" + teamId;
//    }
//
//    //TODO verify
//    //note: Concerns include selling teams that are already sold in another tab or buying too much same way.. by selling/buying alt way
//    @PostMapping("/trade/sell-all")
//    public synchronized ResponseEntity<String> sellAllInUsersPortfolio() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Owns> owns = ownsService.getTeamsUserOwns(user.getID());
//        owns.forEach(team -> {
//            TradeRequest tradeRequest = new TradeRequest(team.getTeamId(), user.getID(), team.getAmountOwned(), TradeAction.SELL);
//            if (ownsService.validateOwnership(tradeRequest) && teamService.isTeamUnLocked(tradeRequest.getTeamId()))
//                transactionService.completeSell(tradeRequest);
//        });
//        return ResponseEntity.ok("OKAY");
//    }

}