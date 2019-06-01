package com.Borman.cbbbluechips.integration

import com.Borman.cbbbluechips.twilio.TwiloBodyBuilderUtility
import com.Borman.cbbbluechips.twilio.TwiloService
import spock.lang.Specification

class TwiloServiceTest extends Specification {

    def "Test Text Message sender"() {

        given:
        String PhoneNumber = "15738261903";
        String body = "You hold shares with Duke. The Game has been completed and Dukes Value has changed"

        when:
        TwiloService.sendMessage(PhoneNumber, body)

        then:
        noExceptionThrown()

    }


    def "Send Message to ME"() {

        when:
        List<String> leaders = Arrays.asList("Keaton", "Jake", "Tyler")
        TwiloService.sendMessage("15738261903", TwiloBodyBuilderUtility.buildUpdateLeadersBody(leaders))

        then:
        noExceptionThrown()

    }

}
