package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.OwnsSQL;
import com.Borman.cbbbluechips.daos.sql.TeamSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.TeamRowMapper;
import com.Borman.cbbbluechips.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Team> getAllTeams() {
        return jdbcTemplate.query(TeamSQL.getAllTeams, new TeamRowMapper());
    }

    public List<Team> onlyTeamsInTournament() {
        return jdbcTemplate.query(TeamSQL.getTournamentTeams, new TeamRowMapper());
    }

    public Team getTeamById(String teamId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
        return namedParameterJdbcTemplate.query(TeamSQL.getTeamById, params, new TeamRowMapper()).get(0);
    }

    public double getCurrentMarketPrice(String teamId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
        return namedParameterJdbcTemplate.queryForObject(OwnsSQL.getCurrentMarketPrice, params, Double.class);
    }


    public String getTeamName(String teamId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
        return namedParameterJdbcTemplate.queryForObject(TeamSQL.getTeamName, params, String.class);
    }

    public Team getTeamByName(String teamId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
        return namedParameterJdbcTemplate.queryForObject(TeamSQL.getTeamById, params, new TeamRowMapper());
    }

}
