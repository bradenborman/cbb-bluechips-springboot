package com.Borman.cbbbluechips.models;

import java.util.List;

public class Portfolio {


    private double cash;
    private List<OwnedTeams> ownedTeams;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<OwnedTeams> getOwnedTeams() {
        return ownedTeams;
    }

    public void setOwnedTeams(List<OwnedTeams> ownedTeams) {
        this.ownedTeams = ownedTeams;
    }

}