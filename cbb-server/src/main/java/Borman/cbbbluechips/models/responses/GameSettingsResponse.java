package Borman.cbbbluechips.models.responses;

public class GameSettingsResponse {

    private String currentRound;
    private boolean signUpAllowed;

    public String getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(String currentRound) {
        this.currentRound = currentRound;
    }

    public boolean isSignUpAllowed() {
        return signUpAllowed;
    }

    public void setSignUpAllowed(boolean signUpAllowed) {
        this.signUpAllowed = signUpAllowed;
    }

}