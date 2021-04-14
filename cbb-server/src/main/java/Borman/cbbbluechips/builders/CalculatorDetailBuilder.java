package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.CalculatorDetail;

public final class CalculatorDetailBuilder {

    private CalculatorDetail calculatorDetail;

    private CalculatorDetailBuilder() {
        calculatorDetail = new CalculatorDetail();
    }

    public static CalculatorDetailBuilder aCalculatorDetail() {
        return new CalculatorDetailBuilder();
    }

    public CalculatorDetailBuilder withTeamNameOwned(String teamNameOwned) {
        calculatorDetail.setTeamNameOwned(teamNameOwned);
        return this;
    }

    public CalculatorDetailBuilder withFinalScoreOwned(int finalScoreOwned) {
        calculatorDetail.setFinalScoreOwned(finalScoreOwned);
        return this;
    }

    public CalculatorDetailBuilder withPointSpreadOwned(String pointSpreadOwned) {
        calculatorDetail.setPointSpreadOwned(pointSpreadOwned);
        return this;
    }

    public CalculatorDetailBuilder withPointSpreadPlaying(String pointSpreadPlaying) {
        calculatorDetail.setPointSpreadPlaying(pointSpreadPlaying);
        return this;
    }

    public CalculatorDetailBuilder withTeamNamePlaying(String teamNamePlaying) {
        calculatorDetail.setTeamNamePlaying(teamNamePlaying);
        return this;
    }

    public CalculatorDetailBuilder withFinalScorePlaying(int finalScorePlaying) {
        calculatorDetail.setFinalScorePlaying(finalScorePlaying);
        return this;
    }

    public CalculatorDetailBuilder withTeamThatCovered(String teamThatCovered) {
        calculatorDetail.setTeamThatCovered(teamThatCovered);
        return this;
    }

    public CalculatorDetailBuilder withCoveredBy(double coveredBy) {
        calculatorDetail.setCoveredBy(coveredBy);
        return this;
    }

    public CalculatorDetailBuilder withTeamOwnedNewValue(double teamOwnedNewValue) {
        calculatorDetail.setTeamOwnedNewValue(teamOwnedNewValue);
        return this;
    }

    public CalculatorDetailBuilder withStartingValue(double startingValue) {
        calculatorDetail.setStartingValue(startingValue);
        return this;
    }

    public CalculatorDetail build() {
        return calculatorDetail;
    }

}