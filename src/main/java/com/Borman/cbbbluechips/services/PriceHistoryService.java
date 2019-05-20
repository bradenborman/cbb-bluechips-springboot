package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.PriceHistoryDao;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.PriceHistory;
import com.Borman.cbbbluechips.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceHistoryService {

    @Autowired
    TeamDao teamDao;

    @Autowired
    PriceHistoryDao priceHistoryDao;

    public PriceHistory getTeamWithPriceHistory(Team team) {
        PriceHistory team_withHistory = new PriceHistory();
        team_withHistory.setTeam(teamDao.getTeamById(team.getTeamId()));
        team_withHistory.setPreviousMarketValues(priceHistoryDao.getPreviousValuesByTeamId(team.getTeamId()));
        return team_withHistory;
    }

    public List<PriceHistory> getAllTeamsWithPriceHistory() {
        List<PriceHistory> allTeamsWithHistory = new ArrayList<>();
        List<Team> allTeams = teamDao.getAllTeams();
        allTeams.forEach(
                team -> {
                    PriceHistory newPriceHistory = new PriceHistory();
                    newPriceHistory.setTeam(team);
                    newPriceHistory.setPreviousMarketValues(priceHistoryDao.getPreviousValuesByTeamId(team.getTeamId()));
                    allTeamsWithHistory.add(newPriceHistory);
                }
        );
        return allTeamsWithHistory;
    }

}
