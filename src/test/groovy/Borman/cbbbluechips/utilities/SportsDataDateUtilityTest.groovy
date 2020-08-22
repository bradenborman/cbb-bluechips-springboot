package Borman.cbbbluechips.utilities

import spock.lang.Specification

class SportsDataDateUtilityTest extends Specification {


     def "SportsDataDateUtility getTodayDateString"() {

             when:
                    String output = SportsDataDateUtility.getTodayDateString();
             then:
                    noExceptionThrown()
                    println output
      }

}
