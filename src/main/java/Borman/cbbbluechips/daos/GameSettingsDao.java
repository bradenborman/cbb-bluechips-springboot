package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.daos.sql.GameSettingsSQL;
import Borman.cbbbluechips.mappers.rowMappers.TeamRowMapper;
import Borman.cbbbluechips.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameSettingsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getCurrentRound() {
        return jdbcTemplate.queryForObject(GameSettingsSQL.getCurrentRound, String.class);
    }

    public void updateCurrentRound(String round) {
        String sql = "UPDATE game_info SET Current_Round = " + round + " WHERE Year = '2019';";
        jdbcTemplate.update(sql);
    }


    public List<Team> getTeamsPlayingTodayWithNoPointSpreadSet() {
        String sql = "SELECT * FROM teams WHERE Next_Team_Playing is not null AND seed > 0;";
        return jdbcTemplate.query(sql, new TeamRowMapper());
    }

    public void deleteAllTransactionFromGame() {
        String sql = "DELETE FROM transaction_history WHERE Transaction_ID > 0";
        jdbcTemplate.update(sql);
    }

    public void deleteAllPriceHistoryFromGame() {
        String sql = "DELETE FROM price_history where Price_ID > 0";
        jdbcTemplate.update(sql);
    }

    public void resetAllTeamsBackToStartingPrice() {
        String sql = "UPDATE teams SET `Current_Market_Price` =  5000 where Team_ID > 0";
        jdbcTemplate.update(sql);
    }

    public void deleteAllFromOwnsTable() {
        String sql = "DELETE FROM owns where Owns_ID > 0";
        jdbcTemplate.update(sql);
    }

    public void updateAllUsersCashBackToStartingCash(int startingCash) {
        String sql = "UPDATE user set Cash = '100000' where User_ID > 0";
        jdbcTemplate.update(sql);
    }

    public void resetLockedAndIsOutStatus() {
        String sql = "UPDATE teams SET Is_Out = false, Is_Locked = false";
        jdbcTemplate.update(sql);
    }
}
