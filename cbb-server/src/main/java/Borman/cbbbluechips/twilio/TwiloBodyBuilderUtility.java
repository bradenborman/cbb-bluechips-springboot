package Borman.cbbbluechips.twilio;

import Borman.cbbbluechips.models.MarketValue;
import Borman.cbbbluechips.models.enums.BaseUrl;

import java.util.List;
import java.util.stream.Collectors;

public class TwiloBodyBuilderUtility {


    public static String buildGameCompletedMessage(MarketValue marketValue, int sharesOwned) {
        return String.format(
                "CBB BLUECHIPS UPDATE:\n%s has completed their game. You own %s shares that are now open for trading at $%,.0f Per-Share.",
                marketValue.getTeamName(), sharesOwned, marketValue.getPrice()
        )
                .concat(
                        buildTotalValueString(marketValue.getTeamName(), sharesOwned, marketValue.getPrice())
                )
                .concat(
                        "\n\nClick Link to trade: " + createTradeTextLink(marketValue.getTeamId())
                );
    }

    private static String createTradeTextLink(String teamId) {
        return BaseUrl.DEPLOYED.getUrl() + "/trade/" + teamId;
    }

    private static String buildTotalValueString(String teamName, int sharesOwned, double newPrice) {
        double totalValue = sharesOwned * newPrice;
        return String.format("\n\n%s's value in your portfolio: $%,.0f", teamName, totalValue);
    }

    public static String buildUpdateLeadersBody(List<String> leaders) {
        return leaders.stream().collect(Collectors.joining("\n", "Current Leaders: \n", ""));
    }

}
