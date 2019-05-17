package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.OwnsSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.OwnsRowMapper;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.TradeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnsDao {

    Logger logger = LoggerFactory.getLogger(OwnsDao.class);

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Owns> getTeamsUserOwns(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.query(OwnsSQL.getTeamsUserOwnsSQL, params, new OwnsRowMapper());
        } catch (Exception e) {
            logger.error("Failed to get Owns for " + userId + "\n" + e);
            return null;
        }
    }

    public void insertNewOwn(Owns owns) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(owns);
            namedParameterJdbcTemplate.update(OwnsSQL.insertIntoOwns, params);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public int getAmountOfSharesOwned(TradeRequest tradeRequest) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(tradeRequest);
        return namedParameterJdbcTemplate.queryForObject(OwnsSQL.getCurrentAmountOwned, params, Integer.class);
    }
}
