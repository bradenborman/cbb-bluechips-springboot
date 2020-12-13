package Borman.cbbbluechips.services


import spock.lang.Specification
import spock.lang.Unroll

class OwnsServiceTest extends Specification {


    def 'calculateAvailableCanPurchase'() {

        given:

        Borman.cbbbluechips.daos.TeamDao teamDao = Stub()
        OwnsService ownsService = new OwnsService(null, teamDao, null)
        double currentMarketPrice = 5000.0

        when:

        teamDao.getCurrentMarketPrice(_) >> currentMarketPrice
        int amountCanBuy = ownsService.calculateAvailableCanPurchase(17500, "3");


        then:
        amountCanBuy == 3
        noExceptionThrown()

    }


    @Unroll
    def 'validateOwnership'() {

        given:

        Borman.cbbbluechips.daos.OwnsDao ownsDao = Stub()
        OwnsService ownsService = new OwnsService(ownsDao, null, null)

        when:
        ownsDao.getAmountOfSharesOwned(_) >> actuallyOwns
        boolean result = ownsService.validateOwnership(new Borman.cbbbluechips.models.TradeRequest(volume: tryingToSell));

        then:
        println String.format("Trying to sell: %s | Actually owned: %s | Allow trade? => %s", tryingToSell, actuallyOwns, result)
        result == expect
        noExceptionThrown()

        where:
        tryingToSell | actuallyOwns | expect
        10           | 7            | false
        10           | 10           | true
        5            | 10           | true


    }


}
