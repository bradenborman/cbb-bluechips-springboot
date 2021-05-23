package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.daos.sql.OwnsSQL;
import Borman.cbbbluechips.mappers.InvestmentRowMapper;
import Borman.cbbbluechips.models.Investment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvestmentDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public InvestmentDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Investment> getTeamsUserOwns(String userId) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return namedParameterJdbcTemplate.query(OwnsSQL.getTeamsUserOwnsSQL, params, new InvestmentRowMapper());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}