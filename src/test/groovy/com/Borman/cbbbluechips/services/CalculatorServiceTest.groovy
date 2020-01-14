package com.Borman.cbbbluechips.services

import com.Borman.cbbbluechips.daos.TeamDao
import com.Borman.cbbbluechips.models.CalculatorDetail
import com.Borman.cbbbluechips.models.Owns
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorServiceTest extends Specification {


    @Unroll
    def "mapCalculatorDetailTest"() {
        given:

        TeamDao teamDao = Mock(TeamDao.class)
        CalculatorService calculatorService = Spy(CalculatorService.class)
        calculatorService.teamDao = teamDao

        when:

        teamDao.getTeamPlayingNext(_ as String) >> "Connecticut"
        calculatorService.setRandomScore() >> 75

        then:

        CalculatorDetail calculatorDetail = calculatorService.mapCalculatorDetail(owns)

        then:
        calculatorDetail.getTeamThatCovered() == teamThatCovered
        calculatorDetail.getCoveredBy() == 5.5d


        where:
        owns                                                                    | teamThatCovered
        new Owns(teamName: "Wichita State", nextPointSpread: "-5.5", teamId: 0) | "Connecticut"
        new Owns(teamName: "Wichita State", nextPointSpread: "5.5", teamId: 0)  | "Wichita State"


    }


    @Unroll
    def "mapCalculatorDetailTest2"() {
        given:

        TeamDao teamDao = Mock(TeamDao.class)
        CalculatorService calculatorService = Spy(CalculatorService.class)
        calculatorService.teamDao = teamDao

        when:

        teamDao.getTeamPlayingNext(_ as String) >> "Connecticut"
        calculatorService.setRandomScore() >>> scored

        then:

        CalculatorDetail calculatorDetail = calculatorService.mapCalculatorDetail(owns)

        then:
        calculatorDetail.getTeamThatCovered() == teamThatCovered

        where:
        owns                                                                   | teamThatCovered | scored
        new Owns(teamName: "Wichita State", nextPointSpread: "0", teamId: 0)   | "Connecticut"   | [75, 80]
        new Owns(teamName: "Wichita State", nextPointSpread: "0", teamId: 0)   | "Wichita State" | [80, 75]
        new Owns(teamName: "Wichita State", nextPointSpread: "-10", teamId: 0) | "Connecticut"   | [75, 80]
        new Owns(teamName: "Wichita State", nextPointSpread: "10", teamId: 0)  | "Wichita State" | [75, 80]

    }

}
