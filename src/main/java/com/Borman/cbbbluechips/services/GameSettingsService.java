package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.GameSettingsDao;
import com.Borman.cbbbluechips.models.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
public class GameSettingsService {

    private Logger logger = LoggerFactory.getLogger(GameSettingsService.class);

    @Autowired
    GameSettingsDao settingsDao;

    @Autowired
    @Qualifier("startingCash")
    int startingCash;

    public String getCurrentRound() {
        return settingsDao.getCurrentRound();
    }

    public void updateRound(String round) {
        Stream<String> validRounds = Stream.of("64", "32", "16", "8", "4", "2", "1");
        if (validRounds.anyMatch(x -> x.equals(round)))
            settingsDao.updateCurrentRound(round);
    }

    public List<Team> getTeamsPlayingTodayWithNoPointSpreadSet() {
       return settingsDao.getTeamsPlayingTodayWithNoPointSpreadSet();
    }

    @Transactional
    public void resetGame() {
        logger.info("~~ REQUEST TO RESET GAME ~~");
        settingsDao.deleteAllTransactionFromGame();
        settingsDao.deleteAllPriceHistoryFromGame();
        settingsDao.resetAllTeamsBackToStartingPrice();
        settingsDao.deleteAllFromOwnsTable();
        settingsDao.updateAllUsersCashBackToStartingCash(startingCash);
        settingsDao.resetLockedAndIsOutStatus();
    }

}
