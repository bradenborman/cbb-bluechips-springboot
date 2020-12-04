package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.PriceHistoryDao;
import Borman.cbbbluechips.models.MarketValue;
import org.springframework.stereotype.Service;

@Service
public class PriceHistoryService {

    private PriceHistoryDao priceHistoryDao;

    public PriceHistoryService(PriceHistoryDao priceHistoryDao) {
        this.priceHistoryDao = priceHistoryDao;
    }

    //todo! reduce sql calls by not selecting by round but instead all and then use a map to set them
    String getPriceHistoryForRound(String teamId, String round) {
        MarketValue marketValue = priceHistoryDao.getPriceForTeamByRound(teamId, round);
        return String.valueOf(marketValue.getPrice());
    }

}