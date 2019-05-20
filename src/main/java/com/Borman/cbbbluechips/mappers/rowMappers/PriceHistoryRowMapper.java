package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.MarketValue;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceHistoryRowMapper implements RowMapper<MarketValue> {
//TODO set col names
    @Override
    public MarketValue mapRow(ResultSet rs, int rownumber) throws SQLException {
        MarketValue marketValue = new MarketValue();
        marketValue.setMarketValueId(rs.getString(""));
        marketValue.setTeamId(rs.getString("Team_ID"));
        marketValue.setPrice(rs.getDouble(""));
        marketValue.setRoundId(rs.getString(""));
        return marketValue;
    }
}