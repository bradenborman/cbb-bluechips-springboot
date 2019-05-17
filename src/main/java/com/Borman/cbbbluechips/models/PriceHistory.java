package com.Borman.cbbbluechips.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class PriceHistory {

    private Team team;
    private List<MarketValue> previousMarketValues;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<MarketValue> getPreviousMarketValues() {
        return previousMarketValues;
    }

    public void setPreviousMarketValues(List<MarketValue> previousMarketValues) {
        this.previousMarketValues = previousMarketValues;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write PriceHistory as string", e);
        }
    }

}
