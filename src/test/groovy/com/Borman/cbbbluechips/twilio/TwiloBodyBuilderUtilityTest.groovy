package com.Borman.cbbbluechips.twilio

import spock.lang.Specification

class TwiloBodyBuilderUtilityTest extends Specification {

    def "Able to build TwiloBodyBuilderUtility"() {

        given:
        String teamName = "Duke"
        int amountOwned = 20
        double newPrice = 5000;
        when:
        String body = TwiloBodyBuilderUtility.buildGameCompletedMessage(teamName, amountOwned, newPrice)

        then:
        body == "CBB BLUECHIPS UPDATE:\n" +
                "Duke has completed their game. You own 20 shares that are now open for trading at \$5,000 Per-Share"

    }

    def "Able to build buildUpdateLeadersBody"() {

        given:
        List<String> leaders = Arrays.asList("Keaton", "Jake", "Tyler")

        when:
        String body = TwiloBodyBuilderUtility.buildUpdateLeadersBody(leaders)

        then:
        body == "Current Leaders: \nKeaton\nJake\nTyler"

    }

}
