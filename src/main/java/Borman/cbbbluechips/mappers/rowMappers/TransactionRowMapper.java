package Borman.cbbbluechips.mappers.rowMappers;

import Borman.cbbbluechips.models.Transaction;
import Borman.cbbbluechips.models.enums.TradeAction;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet rs, int rownumber) throws SQLException {
        //String timeOfTransaction = rs.getString("Time_of_Trade");
        Transaction transaction =new Transaction();
        transaction.setFullName(rs.getString("User_Name"));
        transaction.setTeamName(rs.getString("Team_Name"));

        double cashTraded = rs.getDouble("Amount_Spent");
        transaction.setCashTraded(cashTraded >= 0 ? cashTraded : cashTraded * -1);
        transaction.setVolumeTraded(rs.getInt("Volume_Traded"));
        transaction.setStrTimeofTransaction(rs.getString("Time_of_Trade"));

        if(cashTraded > 0)
            transaction.setTradeAction(TradeAction.BUY.getCode());
        else
            transaction.setTradeAction(TradeAction.SELL.getCode());

        try {
            transaction.setFullName(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
        }catch (Exception e) {}

        return transaction;
    }
}