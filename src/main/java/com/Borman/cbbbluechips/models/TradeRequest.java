package com.Borman.cbbbluechips.models;

import com.Borman.cbbbluechips.models.enums.TradeAction;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TradeRequest {

    private String teamId;
    private String userId;
    private int volume;
    private TradeAction tradeAction;

    public TradeRequest() { }

    public TradeRequest(String teamId, String userId, int volume, TradeAction tradeAction) {
        this.teamId = teamId;
        this.userId = userId;
        this.volume = volume;
        this.tradeAction = tradeAction;
    }

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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
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
