package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.builders.PortfolioBuilder;
import com.Borman.cbbbluechips.models.Portfolio;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    public Portfolio getPortfolioDetails() {
        return PortfolioBuilder.aPortfolio()
                .withPortfolioValue(45000)
                .withCash(5000)
                .withLeadersValue("124000")
                .withRoundOfPlay("Sweet Sixteen")
                .withTeamsOwned(null)
                .withGameTotalTransactionCount("60")
                .withMyTransactionsCount("20")
                .withTotalMoneyInPlay(360354)
                .build();
    }
}
