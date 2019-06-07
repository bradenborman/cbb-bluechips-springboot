package com.Borman.cbbbluechips.models;

public class LeaderboardUser {

    private String userName;
    private int ranking;
    private double value;

    public LeaderboardUser(String userName, int ranking, double value) {
        this.userName = userName;
        this.ranking = ranking;
        this.value = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
