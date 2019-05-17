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

    public List<Transaction> getTransactionsByUser(String UserId) {
        return transactionDao.getAllTransactionByUser(UserId);
    }

    public List<Transaction> getTransactionByTeam(String teamName) {
        return transactionDao.getAllTransactionByTeam(teamName);
    }

    public void buyStockInTeam(TradeRequest tradeRequest) {
        tradeRequest.setTradeAction(TradeAction.BUY);
    }

    @Transactional
    public void completeSell(TradeRequest tradeRequest) {
        tradeRequest.setTradeAction(TradeAction.SELL);
        transactionDao.sellShares(tradeRequest);
        double moneyToAdd = (teamDao.getCurrentMarketPrice(tradeRequest.getTeamId()) * tradeRequest.getVolume());
        //TODO create Transaction object
        //transactionDao.recordTransaction(new Transaction());
        logger.info(String.format("Trade Request: %s => Made $%S", tradeRequest.toString(), moneyToAdd));
    }

}
