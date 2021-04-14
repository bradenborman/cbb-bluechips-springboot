package Borman.cbbbluechips.utilities

import Borman.cbbbluechips.models.usergroups.GroupCreationRequest
import spock.lang.Specification
import spock.lang.Unroll

class UserGroupUtilityTest extends Specification {

    @Unroll
    def "isPasswordRequired Test"() {

        setup:
        GroupCreationRequest request = new GroupCreationRequest(groupPassword: password)

        when:
        boolean isPasswordRequired = UserGroupUtility.isPasswordRequired(request)

        then:
        isPasswordRequired == isRquired

        where:
        password   | isRquired
        "password" | true
        ""         | false
        null       | false

    }


}