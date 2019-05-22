package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.AdminSQL;

import com.Borman.cbbbluechips.daos.sql.TransactionSQL;
import com.Borman.cbbbluechips.models.SportsDataAPI.SportsDataTeam;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class AdminDao {

    Logger logger = LoggerFactory.getLogger(OwnsDao.class);


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

    public void insertTeamFromSportsData(SportsDataTeam team) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(team);
            namedParameterJdbcTemplate.update(AdminSQL.insertFromSportsDataAPI, params);
        } catch (Exception e) {
            System.out.println("Failed to insert from SPORTS DATA API" + e);
        }
    }



}
