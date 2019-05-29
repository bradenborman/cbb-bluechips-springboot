package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.PriceHistoryDao;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.MarketValue;
import com.Borman.cbbbluechips.models.PriceHistory;
import com.Borman.cbbbluechips.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceHistoryService {

    private PriceHistoryDao priceHistoryDao;

    public PriceHistoryService(PriceHistoryDao priceHistoryDao) {
        this.priceHistoryDao = priceHistoryDao;
    }


    String getPriceHistoryForRound(String teamId, String round) {
        MarketValue marketValue = priceHistoryDao.getPriceForTeamByRound(teamId, round);
        return String.valueOf(marketValue.getPrice());
    }

}