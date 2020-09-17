package Borman.cbbbluechips.models;

public class LeaderboardUser {

    private String userName;
    private int ranking;
    private double value;
    private String emailAddress;
    private boolean hasPayedEntryFee;

    public LeaderboardUser(String userName, int ranking, double value, String emailAddress, boolean hasPayedEntryFee) {
        this.userName = userName;
        this.ranking = ranking;
        this.value = value;
        this.emailAddress = emailAddress;
        this.hasPayedEntryFee = hasPayedEntryFee;
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

    public boolean isHasPayedEntryFee() {
        return hasPayedEntryFee;
    }

    public void setHasPayedEntryFee(boolean hasPayedEntryFee) {
        this.hasPayedEntryFee = hasPayedEntryFee;
    }

}