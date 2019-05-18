package com.Borman.cbbbluechips.services;


import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.daos.TransactionDao;
import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.enums.TradeAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    TeamDao teamDao;

    @Autowired
    UserService userService;

    public List<Transaction> getTransactionsByUser(String UserId) {
        return transactionDao.getAllTransactionByUser(UserId);
    }

    public List<Transaction> getTransactionByTeam(String teamName) {
        return transactionDao.getAllTransactionByTeam(teamName);
    }

    @Transactional
    public void buyStockInTeam(TradeRequest tradeRequest, double fundsAvailable) {
        tradeRequest.setTradeAction(TradeAction.BUY);
        double futureMoneySpent = getCurrentMarketPrice(tradeRequest);
        if (fundsAvailable >= futureMoneySpent) {
            transactionDao.buyShares(tradeRequest);
            userService.removeProceedsFromUser(tradeRequest.getUserId(), fundsAvailable);
            logger.info(String.format("Trade Request: %s => Spent $%S", tradeRequest.toString(), fundsAvailable));
        } else {
            logger.info(String.format("Trade Request: %s => Funds not available $%S required", tradeRequest.toString(), futureMoneySpent));
        }
    }

    @Transactional
    public void completeSell(TradeRequest tradeRequest) {
        tradeRequest.setTradeAction(TradeAction.SELL);
        double moneyToAdd = getCurrentMarketPrice(tradeRequest);
        transactionDao.sellShares(tradeRequest);
        userService.addProceedsToUser(tradeRequest.getUserId(), moneyToAdd);
        logger.info(String.format("Trade Request: %s => Made $%S", tradeRequest.toString(), moneyToAdd));
    }

    private double getCurrentMarketPrice(TradeRequest tradeRequest) {
        return teamDao.getCurrentMarketPrice(tradeRequest.getTeamId()) * tradeRequest.getVolume();
    }

}
