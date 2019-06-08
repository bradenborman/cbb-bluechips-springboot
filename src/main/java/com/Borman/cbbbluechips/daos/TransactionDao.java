package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.TransactionSQL;
import com.Borman.cbbbluechips.daos.sql.UserSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.TransactionRowMapper;
import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransactionDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Transaction> getAllTransactionByUser(String userName) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userName", userName);
        return namedParameterJdbcTemplate.query(TransactionSQL.getByUserId, params, new TransactionRowMapper());
    }

    public List<Transaction> getAllTransactionByTeam(String teamName) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamName", teamName);
        return namedParameterJdbcTemplate.query(TransactionSQL.getByTeamName, params, new TransactionRowMapper());
    }

    public void sellShares(TradeRequest tradeRequest) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(tradeRequest);
            namedParameterJdbcTemplate.update(TransactionSQL.sellShares, params);
        } catch (Exception e) {
            System.out.println("Error updating sell" + e);
        }
    }

    public void buyShares(TradeRequest tradeRequest) {
        System.out.println("Buying for first time.");

        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(tradeRequest);
            namedParameterJdbcTemplate.update(TransactionSQL.buyShares, params);
        } catch (Exception e) {
            System.out.println("Error updating buy" + e);
        }
    }

    public void buySharesAgain(TradeRequest tradeRequest) {
        System.out.println("Buying More. Already Purchased before");
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(tradeRequest);
            namedParameterJdbcTemplate.update(TransactionSQL.buySharesAgain, params);
        } catch (Exception e) {
            System.out.println("Error updating buy" + e);
        }
    }


    public void recordTransaction(Transaction transaction) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(transaction);
            namedParameterJdbcTemplate.update(TransactionSQL.insertIntoTransactionHistory, params);
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    public String getTransactionCountTotal() {
        return String.valueOf(jdbcTemplate.queryForObject(TransactionSQL.getCountTotalTransactions, Integer.class));
    }


    public List<Transaction> getAllTransactions() {
        return namedParameterJdbcTemplate.query(TransactionSQL.getAllTransactions, new TransactionRowMapper());
    }

    public List<Transaction> getFilteredTransactions(String sql) {
        return namedParameterJdbcTemplate.query(sql, new TransactionRowMapper());
    }


    //TODO
    public void deleteUsersTransactions(String fullName) {
        try {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("fullName", fullName);
        namedParameterJdbcTemplate.update(TransactionSQL.deleteUsersTransactions, params);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
