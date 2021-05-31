package Borman.cbbbluechips.validation;

import Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeamDataValidator {

    static Logger logger = LoggerFactory.getLogger(TeamDataValidator.class);

    //TODO broken --> null pointer
    public static boolean anyTeamsMissingPointSpread(List<Team> allTeams) {
        boolean x =  allTeams.stream()
                .anyMatch(team -> (team.getPointSpread() == null && (team.getNextTeamPlaying() != null || !team.getNextTeamPlaying().equals(""))));

        if(x)
            logger.warn("Today's matches contains a team with point spread not set");

        return x;
    }

}