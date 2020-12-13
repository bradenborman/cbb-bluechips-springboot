package Borman.cbbbluechips.mappers;

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

        String firstName = rs.getString("First_Name");
        String lastName = rs.getString("Last_Name");

        owns.setFullName(firstName.charAt(0) + ". " + lastName);
        return owns;
    }
}
