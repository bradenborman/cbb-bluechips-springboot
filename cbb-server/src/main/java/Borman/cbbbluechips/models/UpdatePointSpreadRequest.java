package Borman.cbbbluechips.models;

public class UpdatePointSpreadRequest {

    private String teamName;
    private double nextPointSpread;

    public UpdatePointSpreadRequest() { }

    public UpdatePointSpreadRequest(String teamName, double nextPointSpread) {
        this.teamName = teamName;
        this.nextPointSpread = nextPointSpread;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getNextPointSpread() {
        return nextPointSpread;
    }

    public void setNextPointSpread(double nextPointSpread) {
        this.nextPointSpread = nextPointSpread;
    }
}
