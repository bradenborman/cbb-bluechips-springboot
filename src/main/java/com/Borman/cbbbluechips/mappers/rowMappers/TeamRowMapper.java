package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRowMapper implements RowMapper<Team> {

    @Override
    public Team mapRow(ResultSet rs, int rownumber) throws SQLException {
        Team team =new Team();
        team.setTeamId(rs.getString("Team_ID"));
        team.setTeamName(rs.getString("name"));
        team.setSeed(rs.getString("seed"));
        team.setNextPointSpread(rs.getString("point_spread"));
        team.setEliminated(rs.getBoolean("is_out"));
        team.setLogoULR(rs.getString("Logo_URL"));
        team.setCurrentMarketPrice(rs.getDouble("Current_Market_Price"));
        return team;
    }
}
