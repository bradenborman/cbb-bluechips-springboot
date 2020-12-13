package Borman.cbbbluechips.models.paypal;

public class Amount {

    public String value;
    public String currency_code;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value='" + value + '\'' +
                ", currency_code='" + currency_code + '\'' +
                '}';
    }
}