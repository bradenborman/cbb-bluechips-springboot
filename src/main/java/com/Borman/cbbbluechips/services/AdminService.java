package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.AdminDao;
import com.Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    Logger logger = LoggerFactory.getLogger(AdminService.class);

    private RestTemplate restTemplate;
    private AdminDao adminDao;
    private String sportsDataUrl;

    public AdminService(RestTemplate restTemplate, AdminDao adminDao, @Qualifier("sportsDataUrl") String sportsDataUrl) {
        this.restTemplate = restTemplate;
        this.adminDao = adminDao;
        this.sportsDataUrl = sportsDataUrl;
    }

    @Transactional
    public void updateTeamsStoredInDataBase() {
        List<SportsDataTeam> updatedTeamInfo = getTeamsFromSportsDataApi();
        updatedTeamInfo.forEach(this::updateDatabase);
    }

    private void updateDatabase(SportsDataTeam team) {
        logger.info(String.format("Updating %s's Info", team.getSchool()));
        adminDao.updateTeamInfo(team);
    }

    private List<SportsDataTeam> getTeamsFromSportsDataApi() {
        ResponseEntity<SportsDataTeam[]> response = restTemplate.getForEntity(sportsDataUrl, SportsDataTeam[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
