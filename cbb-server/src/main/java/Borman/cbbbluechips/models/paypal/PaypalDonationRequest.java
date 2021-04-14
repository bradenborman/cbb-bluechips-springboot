package Borman.cbbbluechips.models.paypal;

import java.util.List;

public class PaypalDonationRequest {

    public String orderID;
    public String playGivenName;
    public String buyerEmail;
    public List<PurchaseUnit> purchaseUnits;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPlayGivenName() {
        return playGivenName;
    }

    public void setPlayGivenName(String playGivenName) {
        this.playGivenName = playGivenName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public List<PurchaseUnit> getPurchaseUnits() {
        return purchaseUnits;
    }

    public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
    }

    @Override
    public String toString() {
        return "PayEntryFeeRequest{" +
                "orderID='" + orderID + '\'' +
                ", playGivenName='" + playGivenName + '\'' +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", purchaseUnits=" + purchaseUnits +
                '}';
    }

}