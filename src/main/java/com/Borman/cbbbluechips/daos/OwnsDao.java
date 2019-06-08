package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.OwnsSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.OwnsRowMapperTeamJoin;
import com.Borman.cbbbluechips.mappers.rowMappers.OwnsRowMapperUserJoin;
import com.Borman.cbbbluechips.mappers.rowMappers.SMS_AlertRowMapper;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.SMS_Alert;
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


    public List<Owns> getTopShareHoldersForTeam(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
            return namedParameterJdbcTemplate.query(OwnsSQL.getUserOwnsTeamsSQL_Limit3, params, new OwnsRowMapperUserJoin());
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
        try {
            return jdbcTemplate.queryForObject(OwnsSQL.getTotalMoneyInPlay, Double.class);
        } catch (Exception e) {
            logger.info("No one owns anything" + e.toString());
        }
        return 0;
    }

    public List<SMS_Alert> getUsersWhoOwnedTeamWithTextAlertOn(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
            return namedParameterJdbcTemplate.query(OwnsSQL.getUsersWhoOwnedTeamWithTextAlertOn, params, new SMS_AlertRowMapper());
        } catch (Exception e) {
            logger.error("Failed to get Owns for " + teamId + "\n" + e);
            return null;
        }
    }

    //TODO
    public void deleteUserOwns(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            namedParameterJdbcTemplate.update(OwnsSQL.deleteUserOwns, params);
        } catch (Exception e) {
            logger.info(e.toString());
        }
    }


}
