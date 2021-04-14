package Borman.cbbbluechips.models;

import java.util.List;

public class Portfolio {

    private double portfolioValue;
    private double cash;
    private String myTransactionsCount;
    private String gameTotalTransactionCount;
    private String leadersValue;
    private String roundOfPlay;
    private double totalMoneyInPlay;

    public double getPortfolioValue() {
        return portfolioValue;
    }

    public void setPortfolioValue(double portfolioValue) {
        this.portfolioValue = portfolioValue;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getMyTransactionsCount() {
        return myTransactionsCount;
    }

    public void setMyTransactionsCount(String myTransactionsCount) {
        this.myTransactionsCount = myTransactionsCount;
    }

    public String getGameTotalTransactionCount() {
        return gameTotalTransactionCount;
    }

    public void setGameTotalTransactionCount(String gameTotalTransactionCount) {
        this.gameTotalTransactionCount = gameTotalTransactionCount;
    }

    public String getLeadersValue() {
        return leadersValue;
    }

    public void setLeadersValue(String leadersValue) {
        this.leadersValue = leadersValue;
    }

    public String getRoundOfPlay() {
        return roundOfPlay;
    }

    public void setRoundOfPlay(String roundOfPlay) {
        this.roundOfPlay = roundOfPlay;
    }

    public double getTotalMoneyInPlay() {
        return totalMoneyInPlay;
    }

    public void setTotalMoneyInPlay(double totalMoneyInPlay) {
        this.totalMoneyInPlay = totalMoneyInPlay;
    }
}
