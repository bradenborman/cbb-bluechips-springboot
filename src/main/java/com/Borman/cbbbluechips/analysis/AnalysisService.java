package com.Borman.cbbbluechips.analysis;

import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.enums.TradeAction;
import com.Borman.cbbbluechips.services.TransactionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AnalysisService {

    private TransactionService transactionService;

    public AnalysisService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public List<AnalysisBreakdown> buildMyTransactionBreakdown(String userId) {
        List<Transaction> userTransactions = transactionService.getTransactionsByUser(userId);
        Map<String, AnalysisBreakdown> analysisBreakdown = new HashMap<>();

        userTransactions.forEach(transaction -> {

            if (analysisBreakdown.containsKey(transaction.getTeamName())) {
                analysisBreakdown.get(transaction.getTeamName()).setNetProfit(
                        transaction.getTradeAction().equals(TradeAction.BUY.getCode())
                                ?
                                analysisBreakdown.get(transaction.getTeamName()).getNetProfit() - transaction.getCashTraded()
                                :
                                analysisBreakdown.get(transaction.getTeamName()).getNetProfit() + transaction.getCashTraded()
                );
                analysisBreakdown.get(transaction.getTeamName()).upTimesTraded();
            } else {
                analysisBreakdown.put(transaction.getTeamName(), new AnalysisBreakdown(transaction.getTeamName(), 1,
                        transaction.getTradeAction().equals(TradeAction.BUY.getCode()) ?
                                (transaction.getCashTraded() * -1) : transaction.getCashTraded())
                );
            }

        });

        return new ArrayList<>(analysisBreakdown.values());

    }

}