package com.Borman.cbbbluechips.services;


import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.User;
import com.mysql.cj.jdbc.JdbcConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);


    public List<Transaction> getAllTransactions() {

        logger.info("Getting Transactions: FAKE DATA");

        User user = new User();

        user.setFirstName("Braden");
        user.setLastName("Borman");
        user.setEmail("bradenborman@hotmail.com");

        List<Transaction> allTransactions = new ArrayList<>();

        Transaction transaction = new Transaction();
        transaction.setCashAmount(34500);
        transaction.setTeam("Duke");
        transaction.setTimeOfTransaction(LocalDateTime.now().minusDays(2));
        transaction.setUser(user);
        transaction.setVolume(8);

        allTransactions.add(transaction);


        return allTransactions;

    }
}
