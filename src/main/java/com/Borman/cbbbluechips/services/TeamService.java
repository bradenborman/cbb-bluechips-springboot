package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.utilities.NumberGenUtility;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class TeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    private TeamDao teamDao;
    private PriceHistoryService priceHistoryService;

    public TeamService(TeamDao teamDao, PriceHistoryService priceHistoryService) {
        this.teamDao = teamDao;
        this.priceHistoryService = priceHistoryService;
    }

    public List<Team> getAllTeams(boolean onlyTeamsInTournament) {
        List<Team> allTeams = onlyTeamsInTournament ? teamDao.onlyTeamsInTournament() : teamDao.getAllTeams();

        //Replace with actual value
        allTeams.forEach(team -> {
            team.setSharesOutstanding(teamDao.getSharesOutstandingForTeam(team.getTeamId()));
            team.setPriceHistoryString(fetchHistoryDetails(team));
            team.setNextTeamPlaying("next-team");
            team.setNextPointSpread(NumberGenUtility.getRandomPointSpread());
        });
        return allTeams;
    }

    private String fetchHistoryDetails(Team team) {
        LinkedHashMap<String, String> priceMap = new LinkedHashMap<>();
        priceMap.put("64", "5000");
//        priceMap.put("32", priceHistoryService.getPriceHistoryForRound(team.getTeamId(), "32"));
//        priceMap.put("16", priceHistoryService.getPriceHistoryForRound(team.getTeamId(), "16"));
//        priceMap.put("8", NumberGenUtility.getRandomPrice());
//        priceMap.put("4", NumberGenUtility.getRandomPrice());
//        priceMap.put("2", NumberGenUtility.getRandomPrice());
//        priceMap.put("1", NumberGenUtility.getRandomPrice());
        return String.join(" ", priceMap.values());
    }

    public Team getTeamById(String teamId) {
        return teamDao.getTeamByName(teamId);
    }


}
