package Borman.cbbbluechips.services;

import Borman.cbbbluechips.config.SportsDataApiConfig;
import Borman.cbbbluechips.daos.TeamDao;
import Borman.cbbbluechips.models.SportsDataAPI.SportsDataGamesToday;
import Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import Borman.cbbbluechips.utilities.SportsDataDateUtility;
import Borman.cbbbluechips.zdata.SportsDataApiRoutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SportsDataApiService {

    Logger logger = LoggerFactory.getLogger(SportsDataApiService.class);

    private RestTemplate restTemplate;
    private TeamDao teamDao;
    private final String apiKey;
    private final String sportsDataTeamsURL;

    public SportsDataApiService(RestTemplate restTemplate, TeamDao teamDao, SportsDataApiConfig sportsDataApiConfig) {
        this.restTemplate = restTemplate;
        this.teamDao = teamDao;
        this.apiKey = sportsDataApiConfig.getApiKey();
        this.sportsDataTeamsURL = sportsDataApiConfig.getUrl();
    }

    List<SportsDataTeam> callTeamsFromSportsDataApi() {
        logger.info("Calling Sports Data URL: {}", sportsDataTeamsURL);
        ResponseEntity<SportsDataTeam[]> response = restTemplate.getForEntity(sportsDataTeamsURL, SportsDataTeam[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    void updateTeamsPlayingToday() {
        logger.info("Re-setting all teams playing.");
        teamDao.resetNextTeamPlayingForAll();
        List<SportsDataGamesToday> updatedTeamInfo = callGamesByDay();
        updatedTeamInfo.forEach(game -> {
            updateTeamNextGame(game.getAwayTeam(), game.getHomeTeamId());
            updateTeamNextGame(game.getHomeTeam(), game.getAwayTeamId());
        });
    }

    private List<SportsDataGamesToday> callGamesByDay() {

        String todayParam = SportsDataDateUtility.getTodayDateString();
        logger.info("Getting Games and next to play for {}", todayParam);

        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(SportsDataApiRoutes.getGamesByDay + todayParam)
                .queryParam("key", apiKey);
        ResponseEntity<SportsDataGamesToday[]> response = restTemplate.getForEntity(url.build().toUriString(), SportsDataGamesToday[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    private void updateTeamNextGame(String teamPlayingShortName, String teamToUpdateId) {
        logger.info("UPDATE GAME: teamID: {} plays {}", teamToUpdateId, teamPlayingShortName);
        String fullName = teamDao.getNameByShortName(teamPlayingShortName);
        teamDao.updateNextTeamPlayingByTeamID(teamToUpdateId, fullName != null ? fullName : teamPlayingShortName);
    }

}