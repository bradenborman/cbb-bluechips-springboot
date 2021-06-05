package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.SportsDataMatchupResponse;
import Borman.cbbbluechips.models.Team;

import java.time.LocalDate;

public final class SportsDataMatchupResponseBuilder {

    private SportsDataMatchupResponse sportsDataMatchupResponse;

    private SportsDataMatchupResponseBuilder() {
        sportsDataMatchupResponse = new SportsDataMatchupResponse();
    }

    public static SportsDataMatchupResponseBuilder aMatchup() {
        return new SportsDataMatchupResponseBuilder();
    }

    public SportsDataMatchupResponseBuilder withTeam1(Team team1) {
        sportsDataMatchupResponse.setTeam1(team1);
        return this;
    }

    public SportsDataMatchupResponseBuilder withTeam2(Team team2) {
        sportsDataMatchupResponse.setTeam2(team2);
        return this;
    }

    public SportsDataMatchupResponseBuilder withDateOfGame(LocalDate dateOfGame) {
        sportsDataMatchupResponse.setDateOfGame(dateOfGame);
        return this;
    }

    public SportsDataMatchupResponseBuilder withStartTime(String startTime) {
        sportsDataMatchupResponse.setStartTime(startTime);
        return this;
    }

    public SportsDataMatchupResponse build() {
        return sportsDataMatchupResponse;
    }

}