package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.AdminSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.PriceHistoryRowMapper;
import com.Borman.cbbbluechips.models.MarketValue;
import com.Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import com.Borman.cbbbluechips.models.UpdatePointSpreadRequest;
import com.Borman.cbbbluechips.models.UpdateSeedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDao {

    Logger logger = LoggerFactory.getLogger(AdminDao.class);

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void deleteAllTeams() {
        try {
            logger.info("Deleting all teams for insert of teams from API");
            jdbcTemplate.update(AdminSQL.deleteAllTeams);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public void updateTeamInfo(SportsDataTeam team) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(team);
            namedParameterJdbcTemplate.update(AdminSQL.updateTeamInfo, params);
        } catch (Exception e) {
            System.out.println("Failed to update from SPORTS DATA API" + e);
        }
    }

    public void setSeedsToDefault() {
        try {
            logger.info("Resetting All Teams to seed of 0");
            jdbcTemplate.update(AdminSQL.resetSeeds);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public void updateSeedRequest(UpdateSeedRequest updateSeedRequest) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(updateSeedRequest);
            namedParameterJdbcTemplate.update(AdminSQL.updateSeeds, params);
        } catch (Exception e) {
            System.out.println("Failed to update seeds" + e);
        }
    }

    public void updateLockedStatusAndEliminated(String teamName, boolean isEliminated, boolean isLocked) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("teamName", teamName)
                    .addValue("out", isEliminated)
                    .addValue("locked", isLocked);
            namedParameterJdbcTemplate.update(AdminSQL.updateLockedAndEliminated, params);
        } catch (Exception e) {
            System.out.println("Failed to update Locked and Eliminated" + e);
        }
    }


    public void updateMarketPriceByTeamAndRound(MarketValue newMarketValue) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(newMarketValue);
            namedParameterJdbcTemplate.update(AdminSQL.updateMarketPriceByTeam, params);
        } catch (Exception e) {
            System.out.println("Failed to update Market Price By Team And Round" + e);
        }
    }

    public void archivePriceUpdateCreate(MarketValue newMarketValue) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(newMarketValue);
            namedParameterJdbcTemplate.update(AdminSQL.archivePriceUpdateCreate, params);
        } catch (Exception e) {
            System.out.println("Failed to archive Price Update" + e);
        }
    }

    public void archivePriceUpdateRenew(MarketValue newMarketValue) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(newMarketValue);
            namedParameterJdbcTemplate.update(AdminSQL.archivePriceUpdateRenew, params);
        } catch (Exception e) {
            System.out.println("Failed to archive Price Update" + e);
        }
    }


    public boolean checkForRoundPriceExists(MarketValue newMarketValue) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(newMarketValue);
            List<MarketValue> marketValue = namedParameterJdbcTemplate.query(AdminSQL.checkForRoundPriceExists, params, new PriceHistoryRowMapper());
            return marketValue.get(0).getMarketValueId() != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        } catch (Exception e) {
            System.out.println("Failed to checkForRoundPriceExists" + e);
            return false;
        }
    }

    public void updatePointSpreadRequest(UpdatePointSpreadRequest team) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("pointSpread", team.getNextPointSpread())
                    .addValue("teamName", team.getTeamName());

            String sql = "UPDATE teams SET Point_Spread = :pointSpread WHERE Name = :teamName";
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
