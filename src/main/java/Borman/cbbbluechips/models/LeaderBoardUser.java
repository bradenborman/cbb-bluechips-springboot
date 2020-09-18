package Borman.cbbbluechips.models;

public class LeaderBoardUser {

    private String userName;
    private int ranking;
    private double value;
    private String emailAddress;
    private boolean hasPayerDonated;

    public LeaderBoardUser(String userName, int ranking, double value, String emailAddress, boolean hasPayerDonated) {
        this.userName = userName;
        this.ranking = ranking;
        this.value = value;
        this.emailAddress = emailAddress;
        this.hasPayerDonated = hasPayerDonated;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isHasPayerDonated() {
        return hasPayerDonated;
    }

    public void setHasPayerDonated(boolean hasPayerDonated) {
        this.hasPayerDonated = hasPayerDonated;
    }

}