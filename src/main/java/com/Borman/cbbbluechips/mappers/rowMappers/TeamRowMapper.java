package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper implements RowMapper<Team> {

    @Override
    public Team mapRow(ResultSet rs, int rownumber) throws SQLException {
        Team team =new Team();
        team.setTeamId(rs.getInt("idteams"));
        team.setTeamName(rs.getString("name"));
        team.setSeed(rs.getString("seed"));
        team.setNextPointSpead(rs.getString("point_spread"));
        team.setEliminated(rs.getBoolean("is_out"));
        return team;
    }
}
