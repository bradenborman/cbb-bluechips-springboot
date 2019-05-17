package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.daos.sql.TransactionSQL;
import com.Borman.cbbbluechips.mappers.rowMappers.TransactionRowMapper;
import com.Borman.cbbbluechips.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransactionDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Transaction> getAllTransactionByUser(String UserId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", UserId);
        return namedParameterJdbcTemplate.query(TransactionSQL.getByUserId, params, new TransactionRowMapper());
    }

    public List<Transaction> getAllTransactionByTeam(String teamName) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("teamName", teamName);
        return namedParameterJdbcTemplate.query(TransactionSQL.getByTeamName, params, new TransactionRowMapper());
    }

}
