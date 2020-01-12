package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.CalculatorDetail;
import com.Borman.cbbbluechips.models.Owns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class CalculatorService {

    @Autowired
    OwnsService ownsService;

    @Autowired
    TeamDao teamDao;


    public CalculatorDetail getCalculatorDetails(String userId) {
        return ownsService.getTeamsUserOwns(userId)
                .stream()
                .filter(owns -> owns.getNextPointSpread() != null)
                .findFirst()
                .map(this::mapCalculatorDetail)
                .orElse(new CalculatorDetail());
    }

    CalculatorDetail mapCalculatorDetail(Owns owns) {
        CalculatorDetail calculatorDetail = new CalculatorDetail();

        calculatorDetail.setTeamNameOwned(owns.getTeamName());
        calculatorDetail.setPointSpreadOwned(owns.getNextPointSpread() != null ? owns.getNextPointSpread() : "0");
        calculatorDetail.setPointSpreadPlaying(owns.getNextPointSpread() != null ? getPointSpreadPlaying(owns.getNextPointSpread()) : "0");
        calculatorDetail.setTeamNamePlaying(teamDao.getTeamPlayingNext(owns.getTeamId()));

        calculatorDetail.setFinalScoreOwned(setRandomScore());
        calculatorDetail.setFinalScorePlaying(setRandomScore());

        calculatorDetail.setStartingValue(owns.getCurrentMarketPrice());

        deriveResultsOfCalculation(calculatorDetail, owns.getCurrentMarketPrice());

        return calculatorDetail;

    }

    int setRandomScore() {
        Random r = new Random();
        return r.nextInt((80 - 55) + 1) + 55;
    }

    private String getPointSpreadPlaying(String pointSpread) {
        try {
            double ps = Double.parseDouble(pointSpread);
            return String.valueOf(ps * -1);
        } catch (Exception e) {
            return "0";
        }
    }


    private void deriveResultsOfCalculation(CalculatorDetail calculatorDetail, double currentMarketPrice) {

        double adjustedScore_Playing = calculatorDetail.getFinalScorePlaying() + Double.parseDouble(calculatorDetail.getPointSpreadPlaying());

        double adjustedScore_Owned = calculatorDetail.getFinalScoreOwned();

        if (adjustedScore_Playing > adjustedScore_Owned) {
            calculatorDetail.setTeamThatCovered(calculatorDetail.getTeamNamePlaying());
            calculatorDetail.setCoveredBy(adjustedScore_Playing - adjustedScore_Owned);
            calculatorDetail.setTeamOwnedNewValue(currentMarketPrice - (200 * calculatorDetail.getCoveredBy()));

        } else if (adjustedScore_Playing < adjustedScore_Owned) {
            calculatorDetail.setTeamThatCovered(calculatorDetail.getTeamNameOwned());
            calculatorDetail.setCoveredBy(adjustedScore_Owned - adjustedScore_Playing);
            calculatorDetail.setTeamOwnedNewValue(currentMarketPrice + (200 * calculatorDetail.getCoveredBy()));
        } else {
            calculatorDetail.setTeamThatCovered("Split");
            calculatorDetail.setCoveredBy(0);
        }

    }

}
