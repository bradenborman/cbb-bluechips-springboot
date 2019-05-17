package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.mappers.rowMappers.OwnsRowMapper;
import com.Borman.cbbbluechips.mappers.rowMappers.TeamRowMapper;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnsDao {

    Logger logger = LoggerFactory.getLogger(OwnsDao.class);


    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Owns> getTeamsUserOwns(String userId) {

        final String getTeamsUserOwnsSQL = "SELECT Owns_ID, User_ID, teams.Team_ID, Amount_Owned, Name, Seed, Point_Spread, Is_Out  FROM owns " +
                "Right JOIN teams ON owns.Team_ID = teams.Team_ID " +
                "WHERE User_ID = :userId;";
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.query(getTeamsUserOwnsSQL, params, new OwnsRowMapper());
        } catch (Exception e) {
            logger.error("Failed to get Owns for " + userId + "\n" + e);
            return null;
        }
    }





    //INSERT INTO `heroku_f8c10a0dcaaf757`.`owns`
    //(`Owns_ID`,
    //`Team_ID`,
    //`User_ID`,
    //`Amount_Owned`)
    //VALUES
    //(null, '2', '2', '5');

}
