package com.Borman.cbbbluechips.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SportsDataUpdater {

    private final Logger logger = LoggerFactory.getLogger(SportsDataUpdater.class);

    private SportsDataApiService sportsDataApiService;

    public SportsDataUpdater(SportsDataApiService sportsDataApiService) {
        this.sportsDataApiService = sportsDataApiService;
    }


//    @Scheduled(cron = "0/30 * * * * ?")
//    public void updateNextTeamPlayingAndOddsQuick() {
//        logger.info("Scheduled task hit: updateTeamsPlayingToday.");
//        sportsDataApiService.updateTeamsPlayingToday();
//    }


    @Scheduled(cron = "0 0 8 * * ?") //Every day at 8am
    public void updateNextTeamPlayingAndOdds() {
        logger.info("Scheduled task hit: updateTeamsPlayingToday.");
        sportsDataApiService.updateTeamsPlayingToday();
    }


}