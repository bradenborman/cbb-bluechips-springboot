package com.Borman.cbbbluechips.models;

public class Teams {

    private int teamId;
    private boolean isEliminated;
    private String teamName;
    private int seed;
    private TeamData teamData;

    public Teams() {}

    public Teams(boolean isEliminated, String teamName, int seed, TeamData teamData) {
        this.isEliminated = isEliminated;
        this.teamName = teamName;
        this.seed = seed;
        this.teamData = teamData;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public TeamData getTeamData() {
        return teamData;
    }

    public void setTeamData(TeamData teamData) {
        this.teamData = teamData;
    }
}
