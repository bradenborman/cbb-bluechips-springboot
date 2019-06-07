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


//    @Scheduled(cron = "0/20 * * * * ?")
//    public void updateTeamsRecords() {
//        logger.info("\n\nTEST CRON\n\n");
//    }


    @Scheduled(cron = "0 0 5 * * ?") //Every day at 5am
    public void updateNextTeamPlayingAndOdds() {
        logger.info("Scheduled task hit: updateTeamsPlayingToday.");
        sportsDataApiService.updateTeamsPlayingToday();
    }


}