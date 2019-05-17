package com.Borman.cbbbluechips.models;

import com.Borman.cbbbluechips.models.enums.TradeAction;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TradeRequest {

    private String teamId;
    private String userId;
    private String volume;
    private TradeAction tradeAction;
    private String projectedMoneyTransferred;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
    }

    public String getProjectedMoneyTransferred() {
        return projectedMoneyTransferred;
    }

    public void setProjectedMoneyTransferred(String projectedMoneyTransferred) {
        this.projectedMoneyTransferred = projectedMoneyTransferred;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write TradeRequest as string", e);
        }
    }

}
