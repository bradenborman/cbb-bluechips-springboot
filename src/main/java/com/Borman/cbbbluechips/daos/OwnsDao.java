package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.OwnsSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.OwnsRowMapperTeamJoin;
import com.Borman.cbbbluechips.mappers.rowMappers.OwnsRowMapperUserJoin;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.TradeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Owns> getTeamsUserOwns(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.query(OwnsSQL.getTeamsUserOwnsSQL, params, new OwnsRowMapperTeamJoin());
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
       return  getAmountOfSharesOwned(tradeRequest.getUserId(), tradeRequest.getTeamId());
    }

    public int getAmountOfSharesOwned(String userId, String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId).addValue("teamId", teamId);
            return namedParameterJdbcTemplate.queryForObject(OwnsSQL.getCurrentAmountOwned, params, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
    }

    public double getFundsAvailable(String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
        return namedParameterJdbcTemplate.queryForObject(OwnsSQL.getFundsAvailable, params, Double.class);
    }


    public List<Owns> getUsersOwnsForTeam(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
            return namedParameterJdbcTemplate.query(OwnsSQL.getUserOwnsTeamsSQL, params, new OwnsRowMapperUserJoin());
        } catch (Exception e) {
            logger.error("Failed to get Owns for " + teamId + "\n" + e);
            return null;
        }
    }


    public double getPortfolioValue(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.queryForObject(OwnsSQL.getPortfolioValueByID, params, Double.class);
        } catch (Exception e) {
            return 0;
        }
    }


    public double getTotalMoneyInPlay() {
        return jdbcTemplate.queryForObject(OwnsSQL.getTotalMoneyInPlay, Double.class);
    }
}
