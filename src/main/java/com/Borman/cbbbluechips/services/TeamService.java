package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.GameSettingsDao;
import com.Borman.cbbbluechips.daos.OwnsDao;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.utilities.NumberGenUtility;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class TeamService {

    Logger logger = LoggerFactory.getLogger(TeamService.class);

    private TeamDao teamDao;
    private PriceHistoryService priceHistoryService;
    private GameSettingsDao gameSettingsDao;

    public TeamService(TeamDao teamDao, PriceHistoryService priceHistoryService, GameSettingsDao gameSettingsDao) {
        this.teamDao = teamDao;
        this.priceHistoryService = priceHistoryService;
        this.gameSettingsDao = gameSettingsDao;
    }

    public List<Team> getAllTeams(boolean onlyTeamsInTournament) {
        List<Team> allTeams = onlyTeamsInTournament ? teamDao.onlyTeamsInTournament() : teamDao.getAllTeams();

        if (onlyTeamsInTournament) {
            allTeams.forEach(team -> {
                team.setSharesOutstanding(teamDao.getSharesOutstandingForTeam(team.getTeamId()));
                team.setPriceHistoryString(fetchHistoryDetails(team));
                team.setNextTeamPlaying(teamDao.getTeamPlayingNext(team.getTeamId()));
                team.setNextPointSpread(teamDao.getNextPointSpread(team.getTeamId()));
            });
        }
        return allTeams;
    }

    private String fetchHistoryDetails(Team team) {

        int Current_Round = Integer.valueOf(gameSettingsDao.getCurrentRound());
        LinkedHashMap<String, String> priceMap = new LinkedHashMap<>();
        priceMap.put("64", "5000");
        List<Integer> rounds = Arrays.asList(32, 16, 8, 4, 2);
        rounds.forEach(round -> {
            if (Current_Round <= (round * 2)) {
                String latestPrice = priceHistoryService.getPriceHistoryForRound(team.getTeamId(), String.valueOf(round));
                if (!latestPrice.equals("0.0"))
                    priceMap.put(String.valueOf(round), latestPrice);
            }
        });
        return String.join(" ", priceMap.values());
    }


    public Team getTeamById(String teamId) {
        return teamDao.getTeamById(teamId);
    }


    public boolean isTeamLocked(String teamId) {
        return teamDao.isTeamLocked(teamId);
    }
}
