package Borman.cbbbluechips.config;

import Borman.cbbbluechips.daos.GameSettingsDao;
import org.springframework.stereotype.Component;

@Component
public class KeepAliveDatabase {

    private GameSettingsDao gameSettingsDao;

    public KeepAliveDatabase(GameSettingsDao gameSettingsDao) {
        this.gameSettingsDao = gameSettingsDao;
    }

    //Hopefully runs to keep database alive
//    @Scheduled(cron = "0/30 * * * * ?")
//    public void updateNextTeamPlayingAndOddsQuick() {
//        gameSettingsDao.getCurrentRound();
//    }

}