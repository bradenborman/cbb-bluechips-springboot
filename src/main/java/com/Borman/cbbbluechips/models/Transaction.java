package com.Borman.cbbbluechips.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

public class Transaction {

    private String userId;
    private String teamName;
    private int volumeTraded;
    private double cashTraded;
    private LocalDateTime timeOfTransaction;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getVolumeTraded() {
        return volumeTraded;
    }

    public void setVolumeTraded(int volumeTraded) {
        this.volumeTraded = volumeTraded;
    }

    public double getCashTraded() {
        return cashTraded;
    }

    public void setCashTraded(double cashTraded) {
        this.cashTraded = cashTraded;
    }

    public LocalDateTime getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(LocalDateTime timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write Transaction as string", e);
        }
    }

}
