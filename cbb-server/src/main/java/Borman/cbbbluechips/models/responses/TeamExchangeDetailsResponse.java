package Borman.cbbbluechips.models.responses;

import java.util.List;

public class TeamExchangeDetailsResponse {

    private String userId;
    private double purchasingPower;

    private String teamId;
    private String teamName;
    private double currentMarketPrice;
    private String teamPlayingNext;
    private String startTime;


    private int amountSharesOwned;
    private int maximumCanPurchase;


    private List<String> topHolders;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getPurchasingPower() {
        return purchasingPower;
    }

    public void setPurchasingPower(double purchasingPower) {
        this.purchasingPower = purchasingPower;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getCurrentMarketPrice() {
        return currentMarketPrice;
    }

    public void setCurrentMarketPrice(double currentMarketPrice) {
        this.currentMarketPrice = currentMarketPrice;
    }

    public String getTeamPlayingNext() {
        return teamPlayingNext;
    }

    public void setTeamPlayingNext(String teamPlayingNext) {
        this.teamPlayingNext = teamPlayingNext;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getMaximumCanPurchase() {
        return maximumCanPurchase;
    }

    public void setMaximumCanPurchase(int maximumCanPurchase) {
        this.maximumCanPurchase = maximumCanPurchase;
    }

    public int getAmountSharesOwned() {
        return amountSharesOwned;
    }

    public void setAmountSharesOwned(int amountSharesOwned) {
        this.amountSharesOwned = amountSharesOwned;
    }

    public List<String> getTopHolders() {
        return topHolders;
    }

    public void setTopHolders(List<String> topHolders) {
        this.topHolders = topHolders;
    }
}