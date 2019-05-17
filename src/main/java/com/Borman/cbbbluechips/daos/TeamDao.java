package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.TeamSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.TeamRowMapper;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamDao {

    Logger logger = LoggerFactory.getLogger(TeamDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Team> getAllTeams() {
        return jdbcTemplate.query(TeamSQL.getAllTeams, new TeamRowMapper());
    }

}
