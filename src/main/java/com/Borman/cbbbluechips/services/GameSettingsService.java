package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.GameSettingsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameSettingsService {

    @Autowired
    GameSettingsDao settingsDao;

    //TODO
    public String getRoundId() {
        return "16";
    }


}
