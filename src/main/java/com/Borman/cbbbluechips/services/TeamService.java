package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.utilities.NumberGenUtility;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public class TeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    TeamDao teamDao;

    public List<Team> getAllTeams() {
        List<Team> allTeams = teamDao.getAllTeams();
        //Replace with actual value

        allTeams.forEach(team -> {
            team.setSharesOutstanding(NumberGenUtility.getRandomNumber());
            team.setPriceHistory(getPreviousPrices());
            team.setNextTeamPlaying("next team placeholder");
        });
        return allTeams;
    }


    private LinkedHashMap<String, String> getPreviousPrices() {
        LinkedHashMap<String, String> priceMap = new LinkedHashMap<>();
        priceMap.put("64", NumberGenUtility.getRandomPrice());
        priceMap.put("32", NumberGenUtility.getRandomPrice());
        priceMap.put("16", NumberGenUtility.getRandomPrice());
        priceMap.put("8", NumberGenUtility.getRandomPrice());
        priceMap.put("4", NumberGenUtility.getRandomPrice());
        priceMap.put("2", NumberGenUtility.getRandomPrice());
        return priceMap;
    }

}
