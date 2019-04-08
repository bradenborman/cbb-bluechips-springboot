package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.models.DataBreakdown;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    public List<Team> getTeams() {

        logger.info("Getting Teams");

        AtomicInteger id = new AtomicInteger();
        id.set(0);

        return new ArrayList<Team>() {{
            add(new Team(false, "Duke", 2, id.getAndIncrement(), null));
            add(new Team(true, "Kentucky", 5, id.getAndIncrement(), null));
            add(new Team(false, "UCLA", 6, id.getAndIncrement(), null));
            add(new Team(false, "Missouri", 15, id.getAndIncrement(), null));
        }};
    }


    public DataBreakdown getTeamData() {
        logger.info("Getting Team's data");
        DataBreakdown breakdown = new DataBreakdown();
        breakdown.setCoach("Coach K");
        breakdown.setLosses(5);
        breakdown.setWins(28);
        return breakdown;
    }
}
