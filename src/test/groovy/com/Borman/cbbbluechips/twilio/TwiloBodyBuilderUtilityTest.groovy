package com.Borman.cbbbluechips.twilio

import spock.lang.Specification

class TwiloBodyBuilderUtilityTest extends Specification {

    def "Able to build TwiloBodyBuilderUtility"() {

        given:
        String teamName = "Duke"
        String amountOwned = "20"

        when:
        String body = TwiloBodyBuilderUtility.buildGameCompletedMessage(teamName, amountOwned)

        then:
        body == "CBB BLUECHIPS UPDATE: Duke has completed their game. You own 20 shares that are now open for trading"

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
