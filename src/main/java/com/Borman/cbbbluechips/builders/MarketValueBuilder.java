package com.Borman.cbbbluechips.builders;

import com.Borman.cbbbluechips.models.MarketValue;

public final class MarketValueBuilder {
    private String marketValueId;
    private String teamName;
    private String roundId;
    private double price;

    private MarketValueBuilder() {
    }

    public static MarketValueBuilder aMarketValue() {
        return new MarketValueBuilder();
    }

    public MarketValueBuilder withMarketValueId(String marketValueId) {
        this.marketValueId = marketValueId;
        return this;
    }

    public MarketValueBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public MarketValueBuilder withRoundId(String roundId) {
        this.roundId = roundId;
        return this;
    }

    public MarketValueBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public MarketValue build() {
        MarketValue marketValue = new MarketValue();
        marketValue.setMarketValueId(marketValueId);
        marketValue.setTeamName(teamName);
        marketValue.setRoundId(roundId);
        marketValue.setPrice(price);
        return marketValue;
    }
}
