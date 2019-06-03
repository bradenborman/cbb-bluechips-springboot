package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.LeaderboardSQL;
import com.Borman.cbbbluechips.models.LeaderboardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderboardDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    //TODO
    public List<LeaderboardUser> getTopFiftyScores() {
       //jdbcTemplate.update(LeaderboardSQL.getTop50);
        return null;
    }

}
