package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.MarketValue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceHistoryRowMapper implements RowMapper<MarketValue> {

    @Override
    public MarketValue mapRow(ResultSet rs, int rowNumber) throws SQLException {
        MarketValue marketValue = new MarketValue();
        marketValue.setMarketValueId(rs.getString("Price_ID"));
        marketValue.setTeamName(rs.getString("Team_ID"));
        marketValue.setPrice(rs.getDouble("Price"));
        marketValue.setRoundId(rs.getString("Round_ID"));
        return marketValue;
    }

}