package com.Borman.cbbbluechips.analysis

import com.Borman.cbbbluechips.builders.TransactionBuilder
import com.Borman.cbbbluechips.models.Transaction
import com.Borman.cbbbluechips.models.enums.TradeAction
import com.Borman.cbbbluechips.services.TransactionService
import spock.lang.Specification
import spock.lang.Unroll

class AnalysisServiceTest extends Specification {


    @Unroll
    def "buildMyTransactionBreakdown"() {

        given:

        TransactionService transactionService = Mock(TransactionService.class)
        AnalysisService analysisService = new AnalysisService(transactionService);

        List<Transaction> transactionList = Arrays.asList(
                TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(15).withTradeAction(TradeAction.BUY.getCode()).build(),
                TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(15).withTradeAction(TradeAction.BUY.getCode()).build(),
                TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(25).withTradeAction(TradeAction.SELL.getCode()).build(),
                TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(20).withTradeAction(TradeAction.SELL.getCode()).build(),
                TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(10).withTradeAction(TradeAction.BUY.getCode()).build(),
                TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(60).withTradeAction(TradeAction.SELL.getCode()).build(),

                TransactionBuilder.aTransaction().withTeamName("Test2").withCashTraded(50).withTradeAction(TradeAction.BUY.getCode()).build(),
                TransactionBuilder.aTransaction().withTeamName("Test2").withCashTraded(30).withTradeAction(TradeAction.SELL.getCode()).build(),
        )

        when:

        transactionService.getTransactionsByUser(_ as String) >> transactionList

        then:

        List<AnalysisBreakdown> breakdown = analysisService.buildMyTransactionBreakdown("00")

        expect:

        breakdown.get(0).getNetProfit() == team1Net
        breakdown.get(1).getNetProfit() == team2Net

        breakdown.get(0).getTimesTraded() == team1TradedTimes
        breakdown.get(1).getTimesTraded() == team2TradedTimes

        where:

        team1Net | team2Net | team1TradedTimes | team2TradedTimes
        65       | -20      | 6                | 2

    }

}