package Borman.cbbbluechips.models;

public class Matchup {

    private String matchupId;
    private String teamOneId;
    private String teamTwoId;
    private String matchupDate;
    private String matchupStartTime;

    public String getMatchupId() {
        return matchupId;
    }

    public void setMatchupId(String matchupId) {
        this.matchupId = matchupId;
    }

    public String getTeamOneId() {
        return teamOneId;
    }

    public void setTeamOneId(String teamOneId) {
        this.teamOneId = teamOneId;
    }

    public String getTeamTwoId() {
        return teamTwoId;
    }

    public void setTeamTwoId(String teamTwoId) {
        this.teamTwoId = teamTwoId;
    }

    public String getMatchupDate() {
        return matchupDate;
    }

    public void setMatchupDate(String matchupDate) {
        this.matchupDate = matchupDate;
    }

    public String getMatchupStartTime() {
        return matchupStartTime;
    }

    public void setMatchupStartTime(String matchupStartTime) {
        this.matchupStartTime = matchupStartTime;
    }

}