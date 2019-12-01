package com.Borman.cbbbluechips.config;

import com.Borman.cbbbluechips.daos.GameSettingsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KeepAliveDatabase {

    @Autowired
    GameSettingsDao gameSettingsDao;

    /*
        Hopefully runs to keep database alive
     */

//    @Scheduled(cron = "0 0/10 * * * ?")
//    public void updateNextTeamPlayingAndOddsQuick() {
//        gameSettingsDao.getCurrentRound();
//    }

}
