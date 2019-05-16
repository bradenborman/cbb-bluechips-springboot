package com.Borman.cbbbluechips.models;

import java.time.LocalDateTime;

public class Team {

    private int teamId;
    private boolean isEliminated;
    private String teamName;
    private String seed;
    private LocalDateTime nextGameTime;
    private String nextPointSpead;

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

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public LocalDateTime getNextGameTime() {
        return nextGameTime;
    }

    public void setNextGameTime(LocalDateTime nextGameTime) {
        this.nextGameTime = nextGameTime;
    }

    public String getNextPointSpead() {
        return nextPointSpead;
    }

    public void setNextPointSpead(String nextPointSpead) {
        this.nextPointSpead = nextPointSpead;
    }
}
