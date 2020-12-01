package Borman.cbbbluechips.services

import Borman.cbbbluechips.config.SportsDataApiConfig
import Borman.cbbbluechips.models.UpdatePointSpreadRequest
import spock.lang.Specification


class AdminServiceTest extends Specification {


//    def 'validateChangeOfPointSpread INVALID'() {
//
//        given:
//            AdminService adminService = new AdminService(null, null, null, null, null)
//            List<UpdatePointSpreadRequest> updates = Arrays.asList(new UpdatePointSpreadRequest(nextPointSpread: 3.5), new UpdatePointSpreadRequest(nextPointSpread: 3.5))
//        when:
//            adminService.validateChangeOfPointSpread(updates)
//        then:
//            thrown(RuntimeException)
//    }


    def 'validateChangeOfPointSpread VALID'() {

        given:
        SportsDataApiConfig sportsDataApiConfig = new SportsDataApiConfig(url: "", apiKey: "")
            AdminService adminService = new AdminService(null, null, null, null, sportsDataApiConfig)
            List<UpdatePointSpreadRequest> updates = Arrays.asList(
                    new UpdatePointSpreadRequest(nextPointSpread: -3.5),
                    new UpdatePointSpreadRequest(nextPointSpread: 3.5),
                    new UpdatePointSpreadRequest(nextPointSpread: -8.1),
                    new UpdatePointSpreadRequest(nextPointSpread: 8.1)
            )
        when:
            adminService.validateChangeOfPointSpread(updates)

        then:
            noExceptionThrown()
    }


}
