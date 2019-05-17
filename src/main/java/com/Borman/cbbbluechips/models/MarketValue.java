package com.Borman.cbbbluechips.models;

public class MarketValue {

    private String marketValueId;
    private String teamId;
    private String roundId;
    private double price;

    public String getMarketValueId() {
        return marketValueId;
    }

    public void setMarketValueId(String marketValueId) {
        this.marketValueId = marketValueId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
