package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.PriceHistory;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class TeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    TeamDao teamDao;

    public List<Team> getAllTeams() {
        List<Team> allTeams = teamDao.getAllTeams();
        //Replace with actual value
        allTeams.forEach(team -> team.setSharesOutstanding(getRandomNumber()));
        return allTeams;
    }

    private String getRandomNumber() {
        Random rand = new Random();
        int x = rand.nextInt(30);
        return String.valueOf(x);
    }

}
