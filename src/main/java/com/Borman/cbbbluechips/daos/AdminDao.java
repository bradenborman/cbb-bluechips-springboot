package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.AdminSQL;

import com.Borman.cbbbluechips.daos.sql.TransactionSQL;
import com.Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import com.Borman.cbbbluechips.models.Team;
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
}
