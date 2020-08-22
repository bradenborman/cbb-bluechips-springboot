package Borman.cbbbluechips.utilities

import spock.lang.Specification

class CommentTimeStampUtilityTest extends Specification {


    def "getDate"() {
        when:
        String date = CommentTimeStampUtility.getDate()
        then:
        println date
        noExceptionThrown()
    }


    def "getTime"() {
        when:
        String time = CommentTimeStampUtility.getTime()
        then:
        println time
        noExceptionThrown()
    }


}
