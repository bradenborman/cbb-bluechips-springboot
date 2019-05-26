package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Transaction;
import com.Borman.cbbbluechips.models.enums.TradeAction;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet rs, int rownumber) throws SQLException {
        //String timeOfTransaction = rs.getString("Time_of_Trade");
        Transaction transaction =new Transaction();
        transaction.setUserId(rs.getString("User_ID"));
        transaction.setTeamName(rs.getString("Team_Name"));
        transaction.setCashTraded(rs.getDouble("Amount_Spent"));
        transaction.setVolumeTraded(rs.getInt("Volume_Traded"));
        transaction.setStrTimeofTransaction(rs.getString("Time_of_Trade"));
        if(transaction.getCashTraded() > 0)
            transaction.setTradeAction(TradeAction.BUY.getCode());
        else
            transaction.setTradeAction(TradeAction.SELL.getCode());

        try {
            transaction.setFullName(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
        }catch (Exception e) {
            System.out.println("Failed to get Full Name");
        }

        return transaction;
    }
}