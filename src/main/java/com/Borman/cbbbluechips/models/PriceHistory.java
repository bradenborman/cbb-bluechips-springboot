package com.Borman.cbbbluechips.models;

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

}
