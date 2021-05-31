package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.Team;

import java.time.LocalDateTime;

public final class TeamBuilder {
    private Team team;

    private TeamBuilder() {
        team = new Team();
    }

    public static TeamBuilder aTeam() {
        return new TeamBuilder();
    }

    public TeamBuilder withTeamId(String teamId) {
        team.setTeamId(teamId);
        return this;
    }

    public TeamBuilder withTeamName(String teamName) {
        team.setTeamName(teamName);
        return this;
    }

    public TeamBuilder withEliminated(boolean eliminated) {
        team.setEliminated(eliminated);
        return this;
    }

    public TeamBuilder withLocked(boolean locked) {
        team.setLocked(locked);
        return this;
    }

    public TeamBuilder withSeed(String seed) {
        team.setSeed(seed);
        return this;
    }

    public TeamBuilder withLogoULR(String logoULR) {
        team.setLogoULR(logoULR);
        return this;
    }

    public TeamBuilder withNextGameTime(LocalDateTime nextGameTime) {
        team.setNextGameTime(nextGameTime);
        return this;
    }

    public TeamBuilder withNextTeamPlaying(String nextTeamPlaying) {
        team.setNextTeamPlaying(nextTeamPlaying);
        return this;
    }

    public TeamBuilder withPointSpread(String pointSpread) {
        team.setPointSpread(pointSpread);
        return this;
    }

    public TeamBuilder withCurrentMarketPrice(double currentMarketPrice) {
        team.setCurrentMarketPrice(currentMarketPrice);
        return this;
    }

    public TeamBuilder withSharesOutstanding(String sharesOutstanding) {
        team.setSharesOutstanding(sharesOutstanding);
        return this;
    }

    public TeamBuilder withPriceHistoryString(String priceHistoryString) {
        team.setPriceHistoryString(priceHistoryString);
        return this;
    }

    public TeamBuilder withDoesUserOwn(boolean doesUserOwn) {
        team.setDoesUserOwn(doesUserOwn);
        return this;
    }

    public Team build() {
        return team;
    }
}
