package com.Borman.cbbbluechips.services;


import com.Borman.cbbbluechips.daos.TransactionDao;
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

    @Autowired
    TransactionDao transactionDao;

    public List<Transaction> getTransactionsByUser(String UserId) {
       return transactionDao.getAllTransactionByUser(UserId);
    }

    public List<Transaction> getTransactionByTeam(String teamId) {
        return transactionDao.getAllTransactionByTeam(teamId);
    }

}
