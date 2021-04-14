package Borman.cbbbluechips.models.enums;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TradeAction {

    BUY("BUY"),
    SELL("SELL");

    private String code;

    TradeAction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
