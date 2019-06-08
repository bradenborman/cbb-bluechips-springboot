package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.GameSettingsSQL;
import com.Borman.cbbbluechips.daos.sql.TeamSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class GameSettingsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    //TODO
    String getTeamsPlayingForSettingsPointSpread = "SELECT * FROM teams WHERE Next_Team_Playing is not null;";




    public String getCurrentRound() {
        return jdbcTemplate.queryForObject(GameSettingsSQL.getCurrentRound, String.class);
    }

    public void updateCurrentRound(String round) {
        String sql = "UPDATE game_info SET Current_Round = " + round + " WHERE Year = '2019';";
        jdbcTemplate.update(sql);
    }

    public void updatePointSpreadByTeam(String teamID, String nextPointSpread) {

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("pointSpread", nextPointSpread)
                .addValue("teamId", teamID);

        String sql = "UPDATE teams SET Point_Spread = :pointSpread WHERE TEAM_ID = :teamId";
        namedParameterJdbcTemplate.update(sql, params);
    }


}
