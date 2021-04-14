package Borman.cbbbluechips.services;

import Borman.cbbbluechips.builders.TradeCentralBuilder;
import Borman.cbbbluechips.models.TradeCentral;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.responses.TeamExchangeDetailsResponse;
import Borman.cbbbluechips.utilities.ExchangeUtility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeCentralService {

    private OwnsService ownsService;

    public TradeCentralService(OwnsService ownsService) {
        this.ownsService = ownsService;
    }

    public TradeCentral fillTradeCentralDetails(User user, String teamId) {
        return TradeCentralBuilder.aTradeCentral()
                .withAvailableToSell(ownsService.calculateAvailableCanSell(user.getID(), teamId))
                .withMaximumCanPurchase(ownsService.calculateAvailableCanPurchase(user.getCash(), teamId))
                .withTopHolders(buildTopHoldersList(teamId))
                .build();
    }

    public void fillExchangeDetails(TeamExchangeDetailsResponse response) {
        int sharesOwned = ownsService.calculateAvailableCanSell(response.getUserId(), response.getTeamId());
        response.setAmountSharesOwned(sharesOwned);

        int amountCanPurchase = ExchangeUtility.calculateAvailableCanPurchase(response.getPurchasingPower(), response.getCurrentMarketPrice());
        response.setMaximumCanPurchase(amountCanPurchase);

        response.setTopHolders(buildTopHoldersList(response.getTeamId()));
    }

    private List<String> buildTopHoldersList(String teamId) {
        return ownsService.getTopShareHoldersForTeam(teamId).stream()
                .map(owns -> owns.getFullName() + ": " + owns.getAmountOwned()).collect(Collectors.toList());
    }

}