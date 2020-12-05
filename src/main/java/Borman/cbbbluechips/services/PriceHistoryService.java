package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.PriceHistoryDao;
import Borman.cbbbluechips.models.MarketValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceHistoryService {

    private PriceHistoryDao priceHistoryDao;

    public PriceHistoryService(PriceHistoryDao priceHistoryDao) {
        this.priceHistoryDao = priceHistoryDao;
    }

    public List<MarketValue> fetchAllPriceHistory() {
        return priceHistoryDao.fetchAllPriceHistory();
    }

}