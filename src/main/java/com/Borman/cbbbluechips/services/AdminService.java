package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.AdminDao;
import com.Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AdminDao adminDao;

    @Transactional
    public void updateTeamsStoredInDataBase() {
        List<SportsDataTeam> updatedTeamInfo = getTeamsFromSportsDataApi();
        //adminDao.deleteAllTeams();
        updatedTeamInfo.forEach(this::updateDatabase);
    }

    private void updateDatabase(SportsDataTeam team) {
        adminDao.insertTeamFromSportsData(team);
    }


    private List<SportsDataTeam> getTeamsFromSportsDataApi() {
        ResponseEntity<SportsDataTeam[]> response = restTemplate.getForEntity("https://api.sportsdata.io/v3/cbb/scores/json/teams?key=df57fbe761424db78e5c16a103ceb0d0", SportsDataTeam[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
