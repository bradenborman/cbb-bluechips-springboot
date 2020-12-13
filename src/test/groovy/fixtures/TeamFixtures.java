package fixtures;

import Borman.cbbbluechips.builders.TeamBuilder;
import Borman.cbbbluechips.models.Team;

import java.util.Arrays;
import java.util.List;

public class TeamFixtures {

    public List<Team> getListOfTeams() {
        Team one = TeamBuilder.aTeam()
                .withCurrentMarketPrice(5000)
                .withNextPointSpread("5.5")
                .withSeed("7")
                .withTeamId("45")
                .withTeamName("Duke").build();
        Team two = TeamBuilder.aTeam()
                .withCurrentMarketPrice(6500)
                .withNextPointSpread("8.5")
                .withSeed("3")
                .withTeamId("55")
                .withTeamName("Kansas").build();

        return Arrays.asList(one, two);
    }

}
