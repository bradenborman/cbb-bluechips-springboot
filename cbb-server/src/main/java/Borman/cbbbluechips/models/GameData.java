package Borman.cbbbluechips.models;

/*
CBB Bluechips game -- not basketball
 */

public class GameData {

    private String currentRound;
    private double totalMoneyInPlay;
    private int totalTransactionsCount;
    private int gamesLeft;

    public String getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(String currentRound) {
        this.currentRound = currentRound;
    }

    public double getTotalMoneyInPlay() {
        return totalMoneyInPlay;
    }

    public void setTotalMoneyInPlay(double totalMoneyInPlay) {
        this.totalMoneyInPlay = totalMoneyInPlay;
    }

    public int getTotalTransactionsCount() {
        return totalTransactionsCount;
    }

    public void setTotalTransactionsCount(int totalTransactionsCount) {
        this.totalTransactionsCount = totalTransactionsCount;
    }

    public int getGamesLeft() {
        return gamesLeft;
    }

    public void setGamesLeft(int gamesLeft) {
        this.gamesLeft = gamesLeft;
    }
}