package com.Borman.cbbbluechips.services;


import com.Borman.cbbbluechips.builders.TransactionBuilder;
import com.Borman.cbbbluechips.daos.OwnsDao;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.daos.TransactionDao;
import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.enums.TradeAction;
import com.Borman.cbbbluechips.utilities.FilteredSearchUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private TransactionDao transactionDao;
    private TeamDao teamDao;
    private UserService userService;
    private OwnsDao ownsDao;

    public TransactionService(TransactionDao transactionDao, TeamDao teamDao, UserService userService, OwnsDao ownsDao) {
        this.transactionDao = transactionDao;
        this.teamDao = teamDao;
        this.userService = userService;
        this.ownsDao = ownsDao;
    }

    public List<Transaction> getTransactionsByUser(String UserId) {
        return transactionDao.getAllTransactionByUser(userService.getUserFullName(UserId));
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
            buyShares(tradeRequest);
            Transaction transaction = buildTransaction(tradeRequest, futureMoneySpent);
            userService.removeProceedsFromUser(tradeRequest.getUserId(), futureMoneySpent);
            transactionDao.recordTransaction(transaction);
        } else {
            logger.info(String.format("Funds not available $%S required", futureMoneySpent));
        }
    }

    private void buyShares(TradeRequest tradeRequest) {
        if (ownsDao.getAmountOfSharesOwned(tradeRequest) >= 0)
            transactionDao.buySharesAgain(tradeRequest);
        else
            transactionDao.buyShares(tradeRequest);
    }

    @Transactional
    public void completeSell(TradeRequest tradeRequest) {
        double moneyToAdd = getCurrentMarketPrice(tradeRequest);
        logger.info(String.format("Trade Request: %s => Made $%S", tradeRequest.toString(), moneyToAdd));
        Transaction transaction = buildTransaction(tradeRequest, moneyToAdd);
        transactionDao.sellShares(tradeRequest);
        userService.addProceedsToUser(tradeRequest.getUserId(), moneyToAdd);
        transaction.setCashTraded(transaction.getCashTraded() * -1);
        transactionDao.recordTransaction(transaction);
    }

    private double getCurrentMarketPrice(TradeRequest tradeRequest) {
        return teamDao.getCurrentMarketPrice(tradeRequest.getTeamId()) * tradeRequest.getVolume();
    }

    private Transaction buildTransaction(TradeRequest request, final double moneyTraded) {

        final String teamName = teamDao.getTeamNameById(request.getTeamId());
        final String userName = userService.getUserFullName(request.getUserId());
        String now = LocalDateTime.now().minusHours(5).format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));

        Transaction transaction = TransactionBuilder.aTransaction()
                .withFullName(userName)
                .withTeamName(teamName)
                .withCashTraded(moneyTraded)
                .withTradeAction(request.getTradeAction().getCode())
                .withStrTimeofTransaction(now)
                .withVolumeTraded(request.getVolume())
                .build();

        logger.info("Transaction Created: " + transaction.toString());
        return transaction;
    }

    public String getTransactionCountTotal() {
        return transactionDao.getTransactionCountTotal();
    }

    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    public List<Transaction> getFilteredTransaction(String teamName, String userName) {
        String sql = FilteredSearchUtility.buildSQL(teamName, userName);
        return transactionDao.getFilteredTransactions(sql);
    }


    public void deleteUser(String userId) {
        String fullName = userService.getUserFullName(userId);
        transactionDao.deleteUsersTransactions(fullName);
    }


}
