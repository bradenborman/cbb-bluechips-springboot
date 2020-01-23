package com.Borman.cbbbluechips.services

import spock.lang.Specification
import spock.lang.Unroll

class CookieServiceTest extends Specification {


    @Unroll
    def "DisguiseId back to id"() {

        setup:

        CookieService cookieService = new CookieService()


        when:

        String hashed = cookieService.getDisguiseId(userId)
        println hashed

        then:

        userId == cookieService.parseDisguiseId(hashed)

        where:

        userId << ["34536", "4359435", "345344"]

    }


}
