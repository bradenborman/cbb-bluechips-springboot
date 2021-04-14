package Borman.cbbbluechips.services;

import Borman.cbbbluechips.builders.CalculatorDetailBuilder;
import Borman.cbbbluechips.daos.TeamDao;
import Borman.cbbbluechips.models.Owns;
import Borman.cbbbluechips.models.CalculatorDetail;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CalculatorService {

    private OwnsService ownsService;
    private TeamDao teamDao;

    public CalculatorService(OwnsService ownsService, TeamDao teamDao) {
        this.ownsService = ownsService;
        this.teamDao = teamDao;
    }

    public CalculatorDetail getCalculatorDetails(String userId) {
        return ownsService.getTeamsUserOwns(userId)
                .stream()
                .filter(owns -> owns.getNextPointSpread() != null)
                .findFirst()
                .map(this::mapCalculatorDetail)
                .orElse(new CalculatorDetail());
    }

    CalculatorDetail mapCalculatorDetail(Owns owns) {
        CalculatorDetail calculatorDetail =  CalculatorDetailBuilder.aCalculatorDetail()
                .withTeamNameOwned(owns.getTeamName())
                .withPointSpreadOwned(owns.getNextPointSpread() != null ? owns.getNextPointSpread() : "0")
                .withPointSpreadPlaying(owns.getNextPointSpread() != null ? getPointSpreadPlaying(owns.getNextPointSpread()) : "0")
                .withTeamNamePlaying(teamDao.getTeamPlayingNext(owns.getTeamId()))
                .withFinalScoreOwned(setRandomScore())
                .withFinalScorePlaying(setRandomScore())
                .withStartingValue(owns.getCurrentMarketPrice())
                .build();

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
            calculatorDetail.setTeamOwnedNewValue(currentMarketPrice - (100 * calculatorDetail.getCoveredBy()));

        } else if (adjustedScore_Playing < adjustedScore_Owned) {
            calculatorDetail.setTeamThatCovered(calculatorDetail.getTeamNameOwned());
            calculatorDetail.setCoveredBy(adjustedScore_Owned - adjustedScore_Playing);
            calculatorDetail.setTeamOwnedNewValue(currentMarketPrice + (100 * calculatorDetail.getCoveredBy()));
        } else {
            calculatorDetail.setTeamThatCovered("Split");
            calculatorDetail.setCoveredBy(0);
        }

    }

}
