package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.PriceHistorySQL;
import com.Borman.cbbbluechips.mappers.rowMappers.PriceHistoryRowMapper;
import com.Borman.cbbbluechips.models.MarketValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PriceHistoryDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<MarketValue> getPreviousValuesByTeamId(String teamId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
        return namedParameterJdbcTemplate.query(PriceHistorySQL.getTeamById, params, new PriceHistoryRowMapper());
    }


    public MarketValue getPriceForTeamByRound(String teamId, String round) {
       try {
           MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId).addValue("round", round);
           return namedParameterJdbcTemplate.queryForObject(PriceHistorySQL.getTeamPriceByRound, params, new PriceHistoryRowMapper());
       }catch (EmptyResultDataAccessException e) {
            return new MarketValue();
       }catch (Exception e) {
           System.out.println(e);
           return new MarketValue();
       }
    }

}
