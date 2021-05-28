package Borman.cbbbluechips.models.responses;

public class PhoneNumberDetails {

    private String phoneNumber;
    private boolean subscribedToMessages;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSubscribedToMessages() {
        return subscribedToMessages;
    }

    public void setSubscribedToMessages(boolean subscribedToMessages) {
        this.subscribedToMessages = subscribedToMessages;
    }
}