package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.Matchup;
import Borman.cbbbluechips.models.Team;

import java.time.LocalDate;

public final class MatchupBuilder {

    private Matchup matchup;

    private MatchupBuilder() {
        matchup = new Matchup();
    }

    public static MatchupBuilder aMatchup() {
        return new MatchupBuilder();
    }

    public MatchupBuilder withTeam1(Team team1) {
        matchup.setTeam1(team1);
        return this;
    }

    public MatchupBuilder withTeam2(Team team2) {
        matchup.setTeam2(team2);
        return this;
    }

    public MatchupBuilder withDateOfGame(LocalDate dateOfGame) {
        matchup.setDateOfGame(dateOfGame);
        return this;
    }

    public MatchupBuilder withStartTime(String startTime) {
        matchup.setStartTime(startTime);
        return this;
    }

    public Matchup build() {
        return matchup;
    }

}