package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.Team;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.responses.TeamExchangeDetailsResponse;
import Borman.cbbbluechips.utilities.ExchangeUtility;

import java.util.List;

public final class TeamExchangeDetailsResponseBuilder {

    TeamExchangeDetailsResponse teamExchangeDetailsResponse;

    private TeamExchangeDetailsResponseBuilder() {
        teamExchangeDetailsResponse = new TeamExchangeDetailsResponse();
    }

    public static TeamExchangeDetailsResponseBuilder aTeamExchangeDetailsResponse() {
        return new TeamExchangeDetailsResponseBuilder();
    }

    public TeamExchangeDetailsResponseBuilder populateWithUser(User user) {
        teamExchangeDetailsResponse.setUserId(user.getID());
        teamExchangeDetailsResponse.setPurchasingPower(user.getCash());
        return this;
    }

    public TeamExchangeDetailsResponseBuilder populatWithTeam(Team team) {
        teamExchangeDetailsResponse.setTeamId(team.getTeamId());
        teamExchangeDetailsResponse.setTeamName(team.getTeamName());
        teamExchangeDetailsResponse.setTeamPlayingNext(team.getNextTeamPlaying());
        teamExchangeDetailsResponse.setStartTime(ExchangeUtility.setStartTimeFormatted(team.getNextGameTime()));
        teamExchangeDetailsResponse.setCurrentMarketPrice(team.getCurrentMarketPrice());
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withUserId(String userId) {
        teamExchangeDetailsResponse.setUserId(userId);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withPurchasingPower(double purchasingPower) {
        teamExchangeDetailsResponse.setPurchasingPower(purchasingPower);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withTeamId(String teamId) {
        teamExchangeDetailsResponse.setTeamId(teamId);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withTeamName(String teamName) {
        teamExchangeDetailsResponse.setTeamName(teamName);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withCurrentMarketPrice(double currentMarketPrice) {
        teamExchangeDetailsResponse.setCurrentMarketPrice(currentMarketPrice);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withTeamPlayingNext(String teamPlayingNext) {
        teamExchangeDetailsResponse.setTeamPlayingNext(teamPlayingNext);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withStartTime(String startTime) {
        teamExchangeDetailsResponse.setStartTime(startTime);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withAmountSharesOwned(int amountSharesOwned) {
        teamExchangeDetailsResponse.setAmountSharesOwned(amountSharesOwned);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withMaximumCanPurchase(int maximumCanPurchase) {
        teamExchangeDetailsResponse.setMaximumCanPurchase(maximumCanPurchase);
        return this;
    }

    public TeamExchangeDetailsResponseBuilder withTopHolders(List<String> topHolders) {
        teamExchangeDetailsResponse.setTopHolders(topHolders);
        return this;
    }

    public TeamExchangeDetailsResponse build() {
        return teamExchangeDetailsResponse;
    }
}
