package com.Borman.cbbbluechips.models;

import java.sql.Date;

public class OwnedTeams extends Teams {


    private int amountOwned;
    private Date lastTransaction;


    public OwnedTeams(boolean isEliminated, String teamName, int seed, TeamData teamData, int amountOwned, Date lastTransaction) {
        super(isEliminated, teamName, seed, teamData);
        this.amountOwned = amountOwned;
        this.lastTransaction = lastTransaction;
    }


    public int getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(int amountOwned) {
        this.amountOwned = amountOwned;
    }

    public Date getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(Date lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

}
