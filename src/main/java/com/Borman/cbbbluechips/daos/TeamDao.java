package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.OwnsSQL;
import com.Borman.cbbbluechips.daos.sql.TeamSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.TeamRowMapper;
import com.Borman.cbbbluechips.models.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TeamDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

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


    public String getTeamNameById(String teamId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
        return namedParameterJdbcTemplate.queryForObject(TeamSQL.getTeamName, params, String.class);
    }

    public Team getTeamByName(String teamName) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamName", teamName);
        return namedParameterJdbcTemplate.queryForObject(TeamSQL.getTeamByName, params, new TeamRowMapper());
    }

    public String getSharesOutstandingForTeam(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
            String amount = namedParameterJdbcTemplate.queryForObject(TeamSQL.getSharesOutstanding, params, String.class);
            return amount != null ? amount : "0";
        }catch (Exception e) {
            System.out.println(e.toString());
            return "0";
        }
    }


    public void updateNextTeamPlayingByTeamID(String teamToUpdateId, String teamPlayingShortName) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("teamToUpdateId", teamToUpdateId)
                    .addValue("teamPlayingShortName", teamPlayingShortName);

            namedParameterJdbcTemplate.update(TeamSQL.updateNextTeamPlaying, params);
        }catch (Exception e) {
            System.out.println("Failed to Update Next TeamPlaying");
        }
    }


    public String getTeamPlayingNext(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
           return namedParameterJdbcTemplate.queryForObject(TeamSQL.getTeamPlayingNext, params, String.class);
        }catch (Exception e) {
            System.out.println("Failed to getTeamPlayingNext");
            return "";
        }
    }

    public void resetNextTeamPlayingForAll() {
        jdbcTemplate.update(TeamSQL.resetNextTeamPlayingForAll);
    }

    public String getNextPointSpread(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
            String ps = namedParameterJdbcTemplate.queryForObject(TeamSQL.getNextPointSpread, params, String.class);
            return ps != null ? ps : "0";
        }catch (Exception e) {
            System.out.println("Failed to getNextPointSpread");
            return "0";
        }
    }


    public String getNameByShortName(String teamShortName) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamShortName", teamShortName);
            return namedParameterJdbcTemplate.queryForObject(TeamSQL.getNameByShortName, params, String.class);
        }catch (Exception e) {
            return null;
        }
    }


    public boolean isTeamLocked(String teamId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamId", teamId);
            String result =  namedParameterJdbcTemplate.queryForObject(TeamSQL.getLockedStatusByTeam, params, String.class);
            return "1".equals(result);
        }catch (Exception e) {
            return false;
        }
    }
}
