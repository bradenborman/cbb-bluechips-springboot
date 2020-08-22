package Borman.cbbbluechips.mappers.rowMappers;

import Borman.cbbbluechips.models.SMS_Alert;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SMS_AlertRowMapper  implements RowMapper<SMS_Alert> {

    @Override
    public SMS_Alert mapRow(ResultSet rs, int rownumber) throws SQLException {
        SMS_Alert alert =new SMS_Alert();
        alert.setUserId(rs.getString("User_ID"));
        alert.setTeamId(rs.getString("Team_ID"));
        alert.setAmountOwned(rs.getInt("Amount_Owned"));
        alert.setPhoneNumber(rs.getString("Phone_Number"));
        return alert;
    }
}
