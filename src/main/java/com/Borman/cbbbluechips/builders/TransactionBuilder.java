package com.Borman.cbbbluechips.builders;

import com.Borman.cbbbluechips.models.Transaction;

import java.time.LocalDateTime;

public final class TransactionBuilder {
    private String userId;
    private String fullName;
    private String teamName;
    private int volumeTraded;
    private double cashTraded;
    private String tradeAction;
    private LocalDateTime timeOfTransaction;
    private String strTimeofTransaction;

    private TransactionBuilder() {
    }

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public TransactionBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public TransactionBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TransactionBuilder withVolumeTraded(int volumeTraded) {
        this.volumeTraded = volumeTraded;
        return this;
    }

    public TransactionBuilder withCashTraded(double cashTraded) {
        this.cashTraded = cashTraded;
        return this;
    }

    public TransactionBuilder withTradeAction(String tradeAction) {
        this.tradeAction = tradeAction;
        return this;
    }

    public TransactionBuilder withTimeOfTransaction(LocalDateTime timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
        return this;
    }

    public TransactionBuilder withStrTimeofTransaction(String strTimeofTransaction) {
        this.strTimeofTransaction = strTimeofTransaction;
        return this;
    }

    public Transaction build() {
        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setFullName(fullName);
        transaction.setTeamName(teamName);
        transaction.setVolumeTraded(volumeTraded);
        transaction.setCashTraded(cashTraded);
        transaction.setTradeAction(tradeAction);
        transaction.setTimeOfTransaction(timeOfTransaction);
        transaction.setStrTimeofTransaction(strTimeofTransaction);
        return transaction;
    }
}
