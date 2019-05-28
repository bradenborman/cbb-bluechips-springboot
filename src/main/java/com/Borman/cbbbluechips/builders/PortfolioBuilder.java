package com.Borman.cbbbluechips.builders;

import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.Portfolio;

import java.util.List;

public final class PortfolioBuilder {
    private double portfolioValue;
    private double cash;
    private String myTransactionsCount;
    private String gameTotalTransactionCount;
    private String leadersValue;
    private String roundOfPlay;
    private List<Owns> teamsOwned;
    private double totalMoneyInPlay;

    private PortfolioBuilder() {
    }

    public static PortfolioBuilder aPortfolio() {
        return new PortfolioBuilder();
    }

    public PortfolioBuilder withPortfolioValue(double portfolioValue) {
        this.portfolioValue = portfolioValue;
        return this;
    }

    public PortfolioBuilder withCash(double cash) {
        this.cash = cash;
        return this;
    }

    public PortfolioBuilder withMyTransactionsCount(String myTransactionsCount) {
        this.myTransactionsCount = myTransactionsCount;
        return this;
    }

    public PortfolioBuilder withGameTotalTransactionCount(String gameTotalTransactionCount) {
        this.gameTotalTransactionCount = gameTotalTransactionCount;
        return this;
    }

    public PortfolioBuilder withLeadersValue(String leadersValue) {
        this.leadersValue = leadersValue;
        return this;
    }

    public PortfolioBuilder withRoundOfPlay(String roundOfPlay) {
        this.roundOfPlay = roundOfPlay;
        return this;
    }

    public PortfolioBuilder withTeamsOwned(List<Owns> teamsOwned) {
        this.teamsOwned = teamsOwned;
        return this;
    }

    public PortfolioBuilder withTotalMoneyInPlay(double totalMoneyInPlay) {
        this.totalMoneyInPlay = totalMoneyInPlay;
        return this;
    }

    public Portfolio build() {
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioValue(portfolioValue);
        portfolio.setCash(cash);
        portfolio.setMyTransactionsCount(myTransactionsCount);
        portfolio.setGameTotalTransactionCount(gameTotalTransactionCount);
        portfolio.setLeadersValue(leadersValue);
        portfolio.setRoundOfPlay(roundOfPlay);
        portfolio.setTeamsOwned(teamsOwned);
        portfolio.setTotalMoneyInPlay(totalMoneyInPlay);
        return portfolio;
    }
}
