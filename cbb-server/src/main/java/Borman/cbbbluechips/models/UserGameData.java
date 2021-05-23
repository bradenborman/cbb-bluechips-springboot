package Borman.cbbbluechips.models;

public class UserGameData {

    private String fullName;
    private double netWorth;
    private double cash;
    private int leaderboardPosition;
    private int userTransactionCount;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(int leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }

    public int getUserTransactionCount() {
        return userTransactionCount;
    }

    public void setUserTransactionCount(int userTransactionCount) {
        this.userTransactionCount = userTransactionCount;
    }
}