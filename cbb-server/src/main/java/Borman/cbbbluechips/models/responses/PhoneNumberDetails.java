package Borman.cbbbluechips.models.responses;

public class PhoneNumberDetails {

    private String phoneNumber;
    private boolean isSubscribedToMessages;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSubscribedToMessages() {
        return isSubscribedToMessages;
    }

    public void setSubscribedToMessages(boolean subscribedToMessages) {
        isSubscribedToMessages = subscribedToMessages;
    }

}