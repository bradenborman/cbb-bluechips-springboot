package Borman.cbbbluechips.analysis


import Borman.cbbbluechips.services.TransactionService
import spock.lang.Specification
import spock.lang.Unroll

class AnalysisServiceTest extends Specification {


    @Unroll
    def "buildMyTransactionBreakdown"() {

        given:

        TransactionService transactionService = Mock(TransactionService.class)
        AnalysisService analysisService = new AnalysisService(transactionService);

        List<Borman.cbbbluechips.models.Transaction> transactionList = Arrays.asList(
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(15).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.BUY.getCode()).build(),
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(15).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.BUY.getCode()).build(),
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(25).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.SELL.getCode()).build(),
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(20).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.SELL.getCode()).build(),
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(10).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.BUY.getCode()).build(),
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test1").withCashTraded(60).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.SELL.getCode()).build(),

                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test2").withCashTraded(50).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.BUY.getCode()).build(),
                Borman.cbbbluechips.builders.TransactionBuilder.aTransaction().withTeamName("Test2").withCashTraded(30).withTradeAction(Borman.cbbbluechips.models.enums.TradeAction.SELL.getCode()).build(),
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