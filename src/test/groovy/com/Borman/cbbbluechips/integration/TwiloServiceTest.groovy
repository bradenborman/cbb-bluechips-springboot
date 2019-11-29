package com.Borman.cbbbluechips.integration

import com.Borman.cbbbluechips.twilio.TwiloBodyBuilderUtility
import com.Borman.cbbbluechips.twilio.TwiloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TwiloServiceTest extends Specification {


    @Autowired
    TwiloService twiloService;


    def "Test Text Message sender"() {

        given:
        String PhoneNumber = "15738261903";
        String body = "You hold shares with Duke. The Game has been completed and Dukes Value has changed"

        when:
        twiloService.sendMessage(PhoneNumber, body)

        then:
        noExceptionThrown()

    }


    def "Send Message to ME"() {

        when:
        List<String> leaders = Arrays.asList("Keaton", "Jake", "Tyler")
        twiloService.sendMessage("15738261903", TwiloBodyBuilderUtility.buildUpdateLeadersBody(leaders))

        then:
        noExceptionThrown()

    }

}
