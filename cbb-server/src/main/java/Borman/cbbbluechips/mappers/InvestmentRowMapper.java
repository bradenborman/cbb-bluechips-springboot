package Borman.cbbbluechips.mappers;

import Borman.cbbbluechips.models.Investment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestmentRowMapper implements RowMapper<Investment> {

    @Override
    public Investment mapRow(ResultSet rs, int rownumber) throws SQLException {
        Investment investment =new Investment();
        investment.setTeamId(rs.getString("Team_ID"));
        investment.setAmountOwned(rs.getInt("Amount_Owned"));
        investment.setTeamName(rs.getString("Name"));
        investment.setNextPointSpread(rs.getString("Point_Spread"));
        investment.setOutOfPlay(rs.getBoolean("Is_Out"));
        investment.setMarketPrice(rs.getDouble("Current_Market_Price"));
        investment.setLocked(rs.getBoolean("Is_Locked"));
        return investment;
    }
}