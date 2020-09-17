package Borman.cbbbluechips.models;

public class PayEntryFeeRequest {

    private String paypalOrderID;
    private String playGivenName;

    public String getPaypalOrderID() {
        return paypalOrderID;
    }

    public void setPaypalOrderID(String paypalOrderID) {
        this.paypalOrderID = paypalOrderID;
    }

    public String getPlayGivenName() {
        return playGivenName;
    }

    public void setPlayGivenName(String playGivenName) {
        this.playGivenName = playGivenName;
    }

    @Override
    public String toString() {
        return "PayEntryFeeRequest{" +
                "paypalOrderID='" + paypalOrderID + '\'' +
                ", playGivenName='" + playGivenName + '\'' +
                '}';
    }
}