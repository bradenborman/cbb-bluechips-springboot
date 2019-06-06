package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.AdminDao;
import com.Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
class SportsDataApiService {

    @Autowired
    RestTemplate restTemplate;


    void updateTeamsRecords() {
        List<SportsDataTeam> updatedTeamInfo = getTeamsFromSportsDataApi();
        //updatedTeamInfo.forEach(this::updateDatabase);
        System.out.println("Test");
    }

    private void updateDatabase(SportsDataTeam team) {
        //here
    }

    private List<SportsDataTeam> getTeamsFromSportsDataApi() {
        ResponseEntity<SportsDataTeam[]> response = restTemplate.getForEntity("https://api.sportsdata.io/v3/cbb/scores/json/teams?key=df57fbe761424db78e5c16a103ceb0d0", SportsDataTeam[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }


}
