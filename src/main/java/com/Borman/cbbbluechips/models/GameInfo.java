package com.Borman.cbbbluechips.models;

import java.util.List;

public class GameInfo {

    private String gameLobby;
    private boolean isGameOver;
    private double moneyInPlay;
    private String highScore;
    private String roundOfPlay;
    private List<Team> teams;
    private List<User> allUsers;
    private List<Transaction> allTransactions;


    public String getGameLobby() {
        return gameLobby;
    }

    public void setGameLobby(String gameLobby) {
        this.gameLobby = gameLobby;
    }

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

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }

    public String getRoundOfPlay() {
        return roundOfPlay;
    }

    public void setRoundOfPlay(String roundOfPlay) {
        this.roundOfPlay = roundOfPlay;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public List<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<Transaction> allTransactions) {
        this.allTransactions = allTransactions;
    }
}