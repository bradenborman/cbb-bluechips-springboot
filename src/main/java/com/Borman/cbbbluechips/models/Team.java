package com.Borman.cbbbluechips.models;

import java.time.LocalDateTime;

public class Team {

    private int teamId;
    private boolean isEliminated;
    private String teamName;
    private int seed;
    private DataBreakdown dataBreakdown;
    private LocalDateTime nextGameTime;
    private double nextPointSpead;

    public Team() {}

    public Team(boolean isEliminated, String teamName, int seed, int teamId, DataBreakdown dataBreakdown) {
        this.isEliminated = isEliminated;
        this.teamName = teamName;
        this.teamId = teamId;
        this.seed = seed;
        this.dataBreakdown = dataBreakdown;
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

    public DataBreakdown getTeamData() {
        return dataBreakdown;
    }

    public void setTeamData(DataBreakdown dataBreakdown) {
        this.dataBreakdown = dataBreakdown;
    }

    public LocalDateTime getNextGameTime() {
        return nextGameTime;
    }

    public void setNextGameTime(LocalDateTime nextGameTime) {
        this.nextGameTime = nextGameTime;
    }

    public double getNextPointSpead() {
        return nextPointSpead;
    }

    public void setNextPointSpead(double nextPointSpead) {
        this.nextPointSpead = nextPointSpead;
    }
}
