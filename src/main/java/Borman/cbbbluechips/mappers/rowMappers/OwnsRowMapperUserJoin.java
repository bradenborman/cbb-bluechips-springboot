package Borman.cbbbluechips.mappers.rowMappers;

import Borman.cbbbluechips.models.Owns;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnsRowMapperUserJoin implements RowMapper<Owns> {

    @Override
    public Owns mapRow(ResultSet rs, int rownumber) throws SQLException {
        Owns owns =new Owns();
        owns.setOwnsId(rs.getString("Owns_ID"));
        owns.setUserId(rs.getString("User_ID"));
        owns.setTeamId(rs.getString("Team_ID"));
        owns.setAmountOwned(rs.getInt("Amount_Owned"));
        owns.setFullName(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
        return owns;
    }
}
