package Borman.cbbbluechips.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketValue {

    private String marketValueId;
    private String teamName;
    private String teamId;
    private String roundId;
    private double price;

    public String getMarketValueId() {
        return marketValueId;
    }

    public void setMarketValueId(String marketValueId) {
        this.marketValueId = marketValueId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write MarketValue as string", e);
        }
    }

}
