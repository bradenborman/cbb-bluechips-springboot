package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.GameSettingsSQL;
import com.Borman.cbbbluechips.daos.sql.TeamSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameSettingsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getCurrentRound() {
        return jdbcTemplate.queryForObject(GameSettingsSQL.getCurrentRound, String.class);
    }

}
