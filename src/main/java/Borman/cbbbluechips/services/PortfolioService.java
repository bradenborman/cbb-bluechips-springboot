package Borman.cbbbluechips.services;

import Borman.cbbbluechips.builders.PortfolioBuilder;
import Borman.cbbbluechips.models.Portfolio;
import Borman.cbbbluechips.models.User;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {


    private OwnsService ownsService;
    private GameSettingsService gameSettingsService;
    private TransactionService transactionService;

    public PortfolioService(OwnsService ownsService, GameSettingsService gameSettingsService, TransactionService transactionService) {
        this.ownsService = ownsService;
        this.gameSettingsService = gameSettingsService;
        this.transactionService = transactionService;
    }

    public Portfolio getPortfolioDetails(User user) {
        return PortfolioBuilder.aPortfolio()
                .withPortfolioValue(ownsService.getPortfolioValue(user.getID()))
                .withCash(user.getCash())
                .withLeadersValue(ownsService.getLeadersValue())
                .withRoundOfPlay(gameSettingsService.getCurrentRound())
                .withGameTotalTransactionCount(transactionService.getTransactionCountTotal())
                .withMyTransactionsCount(String.valueOf(transactionService.getTransactionsByUser(user.getID()).size()))
                .withTotalMoneyInPlay(ownsService.getTotalMoneyInPlay())
                .build();
    }

}
