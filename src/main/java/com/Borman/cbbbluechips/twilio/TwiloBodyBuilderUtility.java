package com.Borman.cbbbluechips.twilio;

import java.util.List;
import java.util.stream.Collectors;

public class TwiloBodyBuilderUtility {


    public static String buildGameCompletedMessage(String teamName, String sharesOwned) {
        return String.format("CBB BLUECHIPS UPDATE: %s has completed their game. You own %s shares that are now open for trading", teamName, sharesOwned);
    }

    public static String buildUpdateLeadersBody(List<String> leaders) {
        return leaders.stream().collect(Collectors.joining("\n","Current Leaders: \n",""));
    }

}
