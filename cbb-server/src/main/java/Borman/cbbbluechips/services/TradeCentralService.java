package Borman.cbbbluechips.services;

import Borman.cbbbluechips.builders.TeamExchangeDetailsResponseBuilder;
import Borman.cbbbluechips.models.Owns;
import Borman.cbbbluechips.models.Team;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.responses.TeamExchangeDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeCentralService {

    OwnsService ownsService;
    UserService userService;
    TeamService teamService;

    public TradeCentralService(OwnsService ownsService, UserService userService, TeamService teamService) {
        this.ownsService = ownsService;
        this.userService = userService;
        this.teamService = teamService;
    }

    public TeamExchangeDetailsResponse fillExchangeDetails(String userId, String teamId) {

        User user = userService.retrieveUserById(userId);
        Team team = teamService.getTeamByIdWithSharesOutstanding(teamId);

        int sharesOwned = ownsService.calculateAvailableCanSell(userId, teamId);
        List<Owns> topHolders = ownsService.getTopShareHoldersForTeam(teamId);

        return TeamExchangeDetailsResponseBuilder.aTeamExchangeDetailsResponse()
                .populateChildrenWithUser(user)
                .populateChildrenWithTeam(team)
                .withAmountSharesOwned(sharesOwned)
                .withMaximumCanPurchase()
                .withTopHolders(buildTopHoldersList(topHolders))
                .build();

    }

    private List<String> buildTopHoldersList(List<Owns> holders) {
        return holders.stream()
                .map(owns -> owns.getFullName() + ": " + owns.getAmountOwned())
                .collect(Collectors.toList());
    }

}