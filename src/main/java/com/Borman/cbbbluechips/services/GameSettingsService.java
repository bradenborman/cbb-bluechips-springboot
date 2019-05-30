package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.GameSettingsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class GameSettingsService {

    @Autowired
    GameSettingsDao settingsDao;

    public String getCurrentRound() {
        return settingsDao.getCurrentRound();
    }

    public void updateRound(String round) {
        Stream<String> validRounds = Stream.of("64", "32", "16", "8", "4", "2", "1");
        if (validRounds.anyMatch(x -> x.equals(round)))
            settingsDao.updateCurrentRound(round);
    }
}
