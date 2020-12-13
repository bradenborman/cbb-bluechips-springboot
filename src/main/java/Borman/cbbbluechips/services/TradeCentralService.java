package Borman.cbbbluechips.services;

import Borman.cbbbluechips.builders.TradeCentralBuilder;
import Borman.cbbbluechips.models.Owns;
import Borman.cbbbluechips.models.TradeCentral;
import Borman.cbbbluechips.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    private List<String> buildTopHoldersList(String teamId) {
        List<Owns> allOwns = ownsService.getTopShareHoldersForTeam(teamId);
        List<String> topHolders = new ArrayList<>();
        for (Owns owns : allOwns)
            topHolders.add(owns.getFullName() + ": " + owns.getAmountOwned());
        return topHolders;
    }


}
