package com.Borman.cbbbluechips.services;


import com.Borman.cbbbluechips.builders.TransactionBuilder;
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

import java.time.LocalDateTime;
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
        logger.info(String.format("Trade Request: %s => Spent $%S", tradeRequest.toString(), futureMoneySpent));
        if (fundsAvailable >= futureMoneySpent) {
            transactionDao.buyShares(tradeRequest);
            Transaction transaction = buildTransaction(tradeRequest, futureMoneySpent);
            userService.removeProceedsFromUser(tradeRequest.getUserId(), fundsAvailable);
        } else {
            logger.info(String.format("Funds not available $%S required", futureMoneySpent));
        }
    }

    @Transactional
    public void completeSell(TradeRequest tradeRequest) {
        tradeRequest.setTradeAction(TradeAction.SELL);
        double moneyToAdd = getCurrentMarketPrice(tradeRequest);
        logger.info(String.format("Trade Request: %s => Made $%S", tradeRequest.toString(), moneyToAdd));
        Transaction transaction = buildTransaction(tradeRequest, moneyToAdd);
        transactionDao.sellShares(tradeRequest);
        userService.addProceedsToUser(tradeRequest.getUserId(), moneyToAdd);
    }

    private double getCurrentMarketPrice(TradeRequest tradeRequest) {
        return teamDao.getCurrentMarketPrice(tradeRequest.getTeamId()) * tradeRequest.getVolume();
    }

    private Transaction buildTransaction(TradeRequest request, final double moneyTraded) {

        final String teamName = teamDao.getTeamName(request.getTeamId());
        final String userName = userService.getUserFullName(request.getUserId());

        Transaction transaction = TransactionBuilder.aTransaction()
                .withFullName(userName)
                .withTeamName(teamName)
                .withCashTraded(moneyTraded)
                .withTradeAction(request.getTradeAction().getCode())
                .withTimeOfTransaction(LocalDateTime.now())
                .withVolumeTraded(request.getVolume())
                .build();

        logger.info("Transaction Created: " + transaction.toString());
        return transaction;
    }

}
