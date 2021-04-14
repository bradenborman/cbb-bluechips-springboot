package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.TradeCentral;

import java.util.List;

public class TradeCentralBuilder {

    private int maximumCanPurchase;
    private int availableToSell;
    private List<String> topHolders;

    private TradeCentralBuilder() { }

    public static TradeCentralBuilder aTradeCentral() {
        return new TradeCentralBuilder();
    }

    public TradeCentralBuilder withMaximumCanPurchase(int maximumCanPurchase) {
        this.maximumCanPurchase = maximumCanPurchase;
        return this;
    }

    public TradeCentralBuilder withAvailableToSell(int availableToSell) {
        this.availableToSell = availableToSell;
        return this;
    }

    public TradeCentralBuilder withTopHolders(List<String> topHolders) {
        this.topHolders = topHolders;
        return this;
    }

    public TradeCentral build() {
        TradeCentral tradeCentral = new TradeCentral();
        tradeCentral.setMaximumCanPurchase(maximumCanPurchase);
        tradeCentral.setAvailableToSell(availableToSell);
        tradeCentral.setTopHolders(topHolders);
        return tradeCentral;
    }
}
