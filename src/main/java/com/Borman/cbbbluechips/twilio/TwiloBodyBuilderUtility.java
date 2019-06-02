package com.Borman.cbbbluechips.twilio;

import java.util.List;
import java.util.stream.Collectors;

public class TwiloBodyBuilderUtility {


    public static String buildGameCompletedMessage(String teamName, int sharesOwned, double newPrice) {
        return String.format("CBB BLUECHIPS UPDATE:\n%s has completed their game. You own %s shares that are now open for trading at $%,.0f Per-Share", teamName, sharesOwned, newPrice);
    }

    public static String buildUpdateLeadersBody(List<String> leaders) {
        return leaders.stream().collect(Collectors.joining("\n","Current Leaders: \n",""));
    }

}
