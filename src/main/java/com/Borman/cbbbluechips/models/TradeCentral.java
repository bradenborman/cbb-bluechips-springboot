package com.Borman.cbbbluechips.models;

import java.util.List;

public class TradeCentral {

    private int maximumCanPurchase;
    private int availableToSell;
    private List<String> topHolders;


    public int getMaximumCanPurchase() {
        return maximumCanPurchase;
    }

    public void setMaximumCanPurchase(int maximumCanPurchase) {
        this.maximumCanPurchase = maximumCanPurchase;
    }

    public int getAvailableToSell() {
        return availableToSell;
    }

    public void setAvailableToSell(int availableToSell) {
        this.availableToSell = availableToSell;
    }

    public List<String> getTopHolders() {
        return topHolders;
    }

    public void setTopHolders(List<String> topHolders) {
        this.topHolders = topHolders;
    }
}
