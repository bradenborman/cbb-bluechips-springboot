package com.Borman.cbbbluechips.models;

import java.util.List;

public class GameInfo {

    private boolean isGameOver;
    private double moneyInPlay;
    private String highScore;
    private String roundOfPlay;
    private List<Teams> teams;
    private List<User> allUsers;


    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public double getMoneyInPlay() {
        return moneyInPlay;
    }

    public void setMoneyInPlay(double moneyInPlay) {
        this.moneyInPlay = moneyInPlay;
    }

    public String getHighSore() {
        return highScore;
    }

    public void setHighSore(String highSore) {
        this.highScore = highSore;
    }

    public String getRoundOfPlay() {
        return roundOfPlay;
    }

    public void setRoundOfPlay(String roundOfPlay) {
        this.roundOfPlay = roundOfPlay;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Teams> teams) {
        this.teams = teams;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
