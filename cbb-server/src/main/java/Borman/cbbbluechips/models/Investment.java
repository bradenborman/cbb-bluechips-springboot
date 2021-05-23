package Borman.cbbbluechips.models;

public class Investment {

    public String teamId;
    public String teamName;
    public String nextPointSpread;
    public double marketPrice;
    public int amountOwned;
    public boolean outOfPlay;
    public boolean locked;


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

    public String getNextPointSpread() {
        return nextPointSpread;
    }

    public void setNextPointSpread(String nextPointSpread) {
        this.nextPointSpread = nextPointSpread;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(int amountOwned) {
        this.amountOwned = amountOwned;
    }

    public boolean isOutOfPlay() {
        return outOfPlay;
    }

    public void setOutOfPlay(boolean outOfPlay) {
        this.outOfPlay = outOfPlay;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}