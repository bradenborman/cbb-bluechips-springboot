package Borman.cbbbluechips.utilities

import spock.lang.Specification
import spock.lang.Unroll

class FilteredSearchUtilityTest extends Specification {

    @Unroll
    def "Test FilteredSearchUtility"() {
        setup:
            String sql = FilteredSearchUtility.buildSQL(teamName, userName)
        expect:
        println "FilteredSearchUtility ran"
            expect == sql
        where:
            teamName | userName | expect
            ""       | ""       | "SELECT * FROM transaction_history"
            "DUKE"   | "TONY"   | "SELECT * FROM transaction_history WHERE Team_Name = 'DUKE' AND Name = 'TONY'"
            ""       | "TONY"   | "SELECT * FROM transaction_history WHERE Name = 'TONY'"
            "DUKE"   | ""       | "SELECT * FROM transaction_history WHERE Team_Name = 'DUKE'"
    }

}
