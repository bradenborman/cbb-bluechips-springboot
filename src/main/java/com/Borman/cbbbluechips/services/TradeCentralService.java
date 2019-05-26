package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.builders.TradeCentralBuilder;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.TradeCentral;
import com.Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TradeCentralService {

    @Autowired
    OwnsService ownsService;


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
