package Borman.cbbbluechips.models.paypal;

public class PurchaseUnit {

    public String description;
    public String reference_id;
    public Payee payee;
    public Amount amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PurchaseUnit{" +
                "description='" + description + '\'' +
                ", reference_id='" + reference_id + '\'' +
                ", payee=" + payee +
                ", amount=" + amount +
                '}';
    }
}