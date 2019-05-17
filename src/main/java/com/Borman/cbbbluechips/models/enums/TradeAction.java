package com.Borman.cbbbluechips.models.enums;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TradeAction {

    BUY("BUY"),
    SELL("SELL");

    private String code;

    TradeAction(String code) {
        this.code = code;
    }

}
