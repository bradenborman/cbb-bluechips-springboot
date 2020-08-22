package Borman.cbbbluechips.twilio;

import java.util.List;
import java.util.stream.Collectors;

public class TwiloBodyBuilderUtility {


    public static String buildGameCompletedMessage(String teamName, int sharesOwned, double newPrice) {
        return String.format(
                "CBB BLUECHIPS UPDATE:\n%s has completed their game. You own %s shares that are now open for trading at $%,.0f Per-Share.",
                teamName, sharesOwned, newPrice)
                .concat(buildTotalValueString(teamName, sharesOwned, newPrice));
    }


    private static String buildTotalValueString(String teamName, int sharesOwned, double newPrice) {
        double totalValue = sharesOwned * newPrice;
        return String.format("\n\n%s's value in your portfolio: $%,.0f", teamName, totalValue);
    }

    public static String buildUpdateLeadersBody(List<String> leaders) {
        return leaders.stream().collect(Collectors.joining("\n","Current Leaders: \n",""));
    }

}
