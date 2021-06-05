package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.mappers.MatchupRowMapper;
import Borman.cbbbluechips.models.Matchup;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class MatchupDao {

    NamedParameterJdbcTemplate jdbcTemplate;

    public MatchupDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Matchup selectMatchupById(String matchupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("matchupId", matchupId);
        return jdbcTemplate.queryForObject("", params, new MatchupRowMapper());
    }

    public Matchup selectMatchupByTeamOneId(String teamOneId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("teamOneId", teamOneId);
        return jdbcTemplate.queryForObject("", params, new MatchupRowMapper());
    }

    public Matchup selectMatchupByTeamTwoId(String teamTwoId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("teamTwoId", teamTwoId);
        return jdbcTemplate.queryForObject("", params, new MatchupRowMapper());
    }

    public List<Matchup> selectAllMatchupsToday() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("today", Date.valueOf(LocalDate.now()));
        return jdbcTemplate.query("", params, new MatchupRowMapper());
    }

    public List<Matchup> selectNextFewMatchups(String countToSelect) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("limit", countToSelect);
        params.addValue("today", Date.valueOf(LocalDate.now()));
        return jdbcTemplate.query("", params, new MatchupRowMapper());
    }

    public void updateMatchupCompleted(String matchupId, boolean completed) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("matchupId", matchupId);
        params.addValue("completed", completed);
        jdbcTemplate.update("", params);
    }

}