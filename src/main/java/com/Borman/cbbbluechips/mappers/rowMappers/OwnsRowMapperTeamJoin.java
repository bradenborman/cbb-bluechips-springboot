package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Owns;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnsRowMapperTeamJoin implements RowMapper<Owns> {

    @Override
    public Owns mapRow(ResultSet rs, int rownumber) throws SQLException {
        Owns owns =new Owns();
        owns.setOwnsId(rs.getString("Owns_ID"));
        owns.setUserId(rs.getString("User_ID"));
        owns.setTeamId(rs.getString("Team_ID"));
        owns.setAmountOwned(rs.getInt("Amount_Owned"));
        owns.setTeamName(rs.getString("Name"));
        owns.setSeed(rs.getInt("Seed"));
        owns.setNextPointSpread(rs.getString("Point_Spread"));
        owns.setOut(rs.getBoolean("Is_Out"));
        owns.setCurrentMarketPrice(rs.getDouble("Current_Market_Price"));
        owns.setLocked(rs.getBoolean("Is_Locked"));
        return owns;
    }
}
