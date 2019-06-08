package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.GameSettingsSQL;
import com.Borman.cbbbluechips.daos.sql.TeamSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.TeamRowMapper;
import com.Borman.cbbbluechips.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class GameSettingsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public String getCurrentRound() {
        return jdbcTemplate.queryForObject(GameSettingsSQL.getCurrentRound, String.class);
    }

    public void updateCurrentRound(String round) {
        String sql = "UPDATE game_info SET Current_Round = " + round + " WHERE Year = '2019';";
        jdbcTemplate.update(sql);
    }


    public List<Team> getTeamsPlayingTodayWithNoPointSpreadSet() {
        String sql = "SELECT * FROM teams WHERE Next_Team_Playing is not null AND seed > 0;";
        return jdbcTemplate.query(sql, new TeamRowMapper());
    }
}
