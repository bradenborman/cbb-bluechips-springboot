package Borman.cbbbluechips.controllers;

import Borman.cbbbluechips.models.LeaderBoardUser;
import Borman.cbbbluechips.models.Transaction;
import Borman.cbbbluechips.services.LeaderboardService;
import Borman.cbbbluechips.services.OwnsService;
import Borman.cbbbluechips.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class MiscDataController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    OwnsService ownsService;

    @GetMapping("/remainingTransactions")
    public ResponseEntity<List<Transaction>> transactions() {
        return ResponseEntity.ok(transactionService.getTransactionsAfter50());
    }


    @GetMapping("/full-leaderboard")
    public ResponseEntity<List<LeaderBoardUser>> fullLeaderboard() {
        return ResponseEntity.ok(ownsService.getLeadersAnalyticData());
    }

}