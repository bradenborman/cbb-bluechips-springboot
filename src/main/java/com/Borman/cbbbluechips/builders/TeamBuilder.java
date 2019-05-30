package com.Borman.cbbbluechips.builders;

import com.Borman.cbbbluechips.models.Team;

import java.time.LocalDateTime;

public final class TeamBuilder {
    private String teamId;
    private String teamName;
    private boolean eliminated;
    private boolean locked;
    private String seed;
    private String logoULR;
    private LocalDateTime nextGameTime;
    private String nextTeamPlaying;
    private String nextPointSpread;
    private double currentMarketPrice;
    private String sharesOutstanding;
    private String priceHistoryString;
    private boolean doesUserOwn;

    private TeamBuilder() {
    }

    public static TeamBuilder aTeam() {
        return new TeamBuilder();
    }

    public TeamBuilder withTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public TeamBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamBuilder withEliminated(boolean eliminated) {
        this.eliminated = eliminated;
        return this;
    }

    public TeamBuilder withLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public TeamBuilder withSeed(String seed) {
        this.seed = seed;
        return this;
    }

    public TeamBuilder withLogoULR(String logoULR) {
        this.logoULR = logoULR;
        return this;
    }

    public TeamBuilder withNextGameTime(LocalDateTime nextGameTime) {
        this.nextGameTime = nextGameTime;
        return this;
    }

    public TeamBuilder withNextTeamPlaying(String nextTeamPlaying) {
        this.nextTeamPlaying = nextTeamPlaying;
        return this;
    }

    public TeamBuilder withNextPointSpread(String nextPointSpread) {
        this.nextPointSpread = nextPointSpread;
        return this;
    }

    public TeamBuilder withCurrentMarketPrice(double currentMarketPrice) {
        this.currentMarketPrice = currentMarketPrice;
        return this;
    }

    public TeamBuilder withSharesOutstanding(String sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
        return this;
    }

    public TeamBuilder withPriceHistoryString(String priceHistoryString) {
        this.priceHistoryString = priceHistoryString;
        return this;
    }

    public TeamBuilder withDoesUserOwn(boolean doesUserOwn) {
        this.doesUserOwn = doesUserOwn;
        return this;
    }

    public Team build() {
        Team team = new Team();
        team.setTeamId(teamId);
        team.setTeamName(teamName);
        team.setEliminated(eliminated);
        team.setLocked(locked);
        team.setSeed(seed);
        team.setLogoULR(logoULR);
        team.setNextGameTime(nextGameTime);
        team.setNextTeamPlaying(nextTeamPlaying);
        team.setNextPointSpread(nextPointSpread);
        team.setCurrentMarketPrice(currentMarketPrice);
        team.setSharesOutstanding(sharesOutstanding);
        team.setPriceHistoryString(priceHistoryString);
        team.setDoesUserOwn(doesUserOwn);
        return team;
    }
}
