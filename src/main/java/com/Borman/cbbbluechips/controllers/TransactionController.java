package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trade")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/sell")
    public ResponseEntity<String> sellTeam(@RequestBody TradeRequest tradeRequest) {
        transactionService.sellStockInTeam(tradeRequest);
        return ResponseEntity.ok("SOLD");
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyTeam(@RequestBody TradeRequest tradeRequest) {
        transactionService.buyStockInTeam(tradeRequest);
        return ResponseEntity.ok("BOUGHT");
    }

    @GetMapping("/transaction/user/{userId}")
    public ResponseEntity<String> getTransactionByUser(@PathVariable String userId) {
        transactionService.getTransactionsByUser(userId);
        return ResponseEntity.ok("TRANSACTIONS RETURNED");
    }

    @GetMapping("/transaction/team/{teamId}")
    public ResponseEntity<String> getTransactionByTeam(@PathVariable String teamId) {
        transactionService.getTransactionByTeam(teamId);
        return ResponseEntity.ok("TRANSACTIONS RETURNED");
    }

}
