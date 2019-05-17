package com.Borman.cbbbluechips.controllers;

import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.services.OwnsService;
import com.Borman.cbbbluechips.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trade")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    OwnsService ownsService;

    @PostMapping("/sell")
    public ResponseEntity<String> sellTeam(@RequestBody TradeRequest tradeRequest) {
        if(ownsService.validateOwnership(tradeRequest))
            transactionService.completeSell(tradeRequest);
        return ResponseEntity.ok("SOLD");
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyTeam(@RequestBody TradeRequest tradeRequest) {
        transactionService.buyStockInTeam(tradeRequest);
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
