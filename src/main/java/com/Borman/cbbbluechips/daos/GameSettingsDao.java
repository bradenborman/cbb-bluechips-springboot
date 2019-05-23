package com.Borman.cbbbluechips.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameSettingsDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


}
