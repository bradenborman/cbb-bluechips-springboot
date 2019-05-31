package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.User;
import com.Borman.cbbbluechips.models.enums.TradeAction;
import com.Borman.cbbbluechips.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class TradeController {

    private TransactionService transactionService;
    private OwnsService ownsService;
    private CookieService cookieService;
    private UserService userService;
    private TeamService teamService;
    private TradeCentralService tradeCentralService;

    public TradeController(TransactionService transactionService, OwnsService ownsService, CookieService cookieService, UserService userService,
                           TeamService teamService, TradeCentralService tradeCentralService) {
        this.transactionService = transactionService;
        this.ownsService = ownsService;
        this.cookieService = cookieService;
        this.userService = userService;
        this.teamService = teamService;
        this.tradeCentralService = tradeCentralService;
    }

    @RequestMapping("/trade/{team_Id}")
    public String tradeCentral(HttpServletRequest request, @PathVariable("team_Id") String teamId, Model model) {
        if (!cookieService.isLoggedIn(request)) {
            return "redirect:/";
        } else {
            User user = userService.getUser(cookieService.getUserIdLoggedIn(request));
            model.addAttribute("user", user);
            model.addAttribute("team", teamService.getTeamById(teamId));
            model.addAttribute("details", tradeCentralService.fillTradeCentralDetails(user, teamId));
            return "trade";
        }
    }

    @PostMapping("/trade-action/sell")
    public String sellTeam(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        if (cookieService.isLoggedIn(request)) {
            TradeRequest tradeRequest = new TradeRequest(teamId, cookieService.getUserIdLoggedIn(request), volume, TradeAction.SELL);
            if (ownsService.validateOwnership(tradeRequest))
                transactionService.completeSell(tradeRequest);
            return "redirect:../trade/" + teamId;
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/trade-action/buy")
    public String buyTeam(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        if (cookieService.isLoggedIn(request)) {
            TradeRequest tradeRequest = new TradeRequest(teamId, cookieService.getUserIdLoggedIn(request), volume, TradeAction.BUY);
            double fundsAvailable = ownsService.getFundsAvailable(tradeRequest);
            transactionService.buyStockInTeam(tradeRequest, fundsAvailable);
            return "redirect:../trade/" + teamId;
        } else {
            return "redirect:../";
        }
    }

}
