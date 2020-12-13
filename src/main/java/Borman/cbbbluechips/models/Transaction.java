package Borman.cbbbluechips.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

public class Transaction {

    private String userId;
    private String fullName;
    private String teamName;
    private int volumeTraded;
    private double cashTraded;
    private String tradeAction;
    private LocalDateTime timeOfTransaction;
    private String strTimeofTransaction;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(String tradeAction) {
        this.tradeAction = tradeAction;
    }

    public String getStrTimeofTransaction() {
        return strTimeofTransaction;
    }

    public void setStrTimeofTransaction(String strTimeofTransaction) {
        this.strTimeofTransaction = strTimeofTransaction;
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
