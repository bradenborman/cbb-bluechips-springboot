package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Transaction;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet rs, int rownumber) throws SQLException {
        String timeOfTransaction = rs.getString("time_of_transaction");
        Transaction transaction =new Transaction();
        transaction.setTimeOfTransaction(LocalDateTime.parse(timeOfTransaction));
        transaction.setTeamName(rs.getString("name"));
        transaction.setCashTraded(rs.getDouble("amountTraded"));
        transaction.setVolumeTraded(rs.getInt("amount"));
        return transaction;
    }
}