package Borman.cbbbluechips.models;

public class UpdateSeedRequest {

    private String teamName;
    private String newSeed;

    public UpdateSeedRequest(String teamName, String newSeed) {
        this.teamName = teamName;
        this.newSeed = newSeed;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getNewSeed() {
        return newSeed;
    }

    public void setNewSeed(String newSeed) {
        this.newSeed = newSeed;
    }
}
