package Borman.cbbbluechips.services;

import Borman.cbbbluechips.config.GameRules;
import Borman.cbbbluechips.daos.TeamDao;
import Borman.cbbbluechips.email.EmailService;
import Borman.cbbbluechips.models.MarketValue;
import Borman.cbbbluechips.models.Team;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TeamService {

    TeamDao teamDao;
    PriceHistoryService priceHistoryService;
    EmailService emailService;
    GameRules gameRules;

    public TeamService(TeamDao teamDao, PriceHistoryService priceHistoryService, EmailService emailService, GameRules gameRules) {
        this.teamDao = teamDao;
        this.priceHistoryService = priceHistoryService;
        this.emailService = emailService;
        this.gameRules = gameRules;
    }

    public List<Team> getAllTeams(boolean onlyTeamsInTournament) {
        List<Team> allTeams = onlyTeamsInTournament ? teamDao.getAllTeamsWithSharesOutstandingDetail() : teamDao.getAllTeams();
        List<MarketValue> historicalData = priceHistoryService.fetchAllPriceHistory();

//        if(TeamDataValidator.anyTeamsMissingPointSpread(allTeams))
//            emailService.sendSetPointSpreadReminderEmail();

        if (onlyTeamsInTournament)
            allTeams.forEach(team -> applyTeamPriceHistory(team, historicalData));

        return allTeams;
    }

    private void applyTeamPriceHistory(Team team, List<MarketValue> historicalData) {
        //Limit down to just team's data
        List<MarketValue> onlySelectedTeam = historicalData.stream()
                .filter(marketValue -> marketValue.getTeamId().equals(team.getTeamId()))
                .collect(Collectors.toList());

        String priceHistoryString = fetchHistoryDetails(team, onlySelectedTeam);

        team.setPriceHistoryString(priceHistoryString);
    }

    private String fetchHistoryDetails(Team team, List<MarketValue> onlySelectedTeam) {
        LinkedHashMap<String, String> priceMap = new LinkedHashMap<>();
        priceMap.put("64", String.valueOf(gameRules.getStartingPricePerShare()));
        List<String> rounds = Arrays.asList("32", "16", "8", "4", "2", "1");
        rounds.forEach(round -> {
            Optional<MarketValue> matchedValueForRound = onlySelectedTeam.stream()
                    .filter(marketValue -> marketValue.getRoundId().equals(round))
                    .findFirst();

            matchedValueForRound.ifPresent(marketValue -> priceMap.put(round, String.valueOf(marketValue.getPrice())));
        });
        return String.join(" ", priceMap.values());
    }


    public Team getTeamByIdWithSharesOutstanding(String teamId) {
        return teamDao.getTeamByIdWithSharesOutstanding(teamId);
    }

    public Team getTeamById(String teamId) {
        return teamDao.getTeamById(teamId);
    }


    public boolean isTeamUnLocked(String teamId) {
        return !teamDao.isTeamLocked(teamId);
    }
}
