package Borman.cbbbluechips.models;

import Borman.cbbbluechips.models.enums.TradeAction;

public final class TradeRequestBuilder {
    private String teamId;
    private String userId;
    private int volume;
    private TradeAction tradeAction;

    private TradeRequestBuilder() {
    }

    public static TradeRequestBuilder aTradeRequest() {
        return new TradeRequestBuilder();
    }

    public TradeRequestBuilder withTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public TradeRequestBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public TradeRequestBuilder withVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public TradeRequestBuilder withTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
        return this;
    }

    public TradeRequest build() {
        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setTeamId(teamId);
        tradeRequest.setUserId(userId);
        tradeRequest.setVolume(volume);
        tradeRequest.setTradeAction(tradeAction);
        return tradeRequest;
    }
}
