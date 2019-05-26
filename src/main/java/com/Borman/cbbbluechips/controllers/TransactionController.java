package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.enums.TradeAction;
import com.Borman.cbbbluechips.services.OwnsService;
import com.Borman.cbbbluechips.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/trade-action")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    OwnsService ownsService;

    private String userId = "2";

    @PostMapping("/sell")
    public String sellTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        TradeRequest tradeRequest = new TradeRequest(teamId, userId, volume, TradeAction.SELL);
        if (ownsService.validateOwnership(tradeRequest))
            transactionService.completeSell(tradeRequest);
        return "confirmation";
    }


    //TODO Try to update first => if result set is 0 then insert
    @PostMapping("/buy")
    public ResponseEntity<String> buyTeam(@RequestParam(value = "teamId") String teamId, @RequestParam(value = "volume") int volume) {
        TradeRequest tradeRequest = new TradeRequest(teamId, userId, volume, TradeAction.BUY);
        double fundsAvailable = ownsService.getFundsAvailable(tradeRequest);
            transactionService.buyStockInTeam(tradeRequest, fundsAvailable);
        return ResponseEntity.ok("BOUGHT");
    }

    @GetMapping("/transaction/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionByUser(@PathVariable String userId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUser(userId));
    }

    @GetMapping("/transaction/team/{teamName}")
    public ResponseEntity<List<Transaction>> getTransactionByTeam(@PathVariable String teamName) {
        return ResponseEntity.ok(transactionService.getTransactionByTeam(teamName));
    }

}
