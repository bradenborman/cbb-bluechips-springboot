package com.Borman.cbbbluechips.models;

public class CalculatorDetail {

    private String teamNameOwned;
    private int finalScoreOwned;
    private String pointSpreadOwned;

    private String pointSpreadPlaying;
    private String teamNamePlaying;
    private int finalScorePlaying;

    private String teamThatCovered;
    private double coveredBy;
    private double teamOwnedNewValue;
    private double startingValue;

    public String getTeamNameOwned() {
        return teamNameOwned;
    }

    public void setTeamNameOwned(String teamNameOwned) {
        this.teamNameOwned = teamNameOwned;
    }

    public double getFinalScoreOwned() {
        return finalScoreOwned;
    }

    public void setFinalScoreOwned(int finalScoreOwned) {
        this.finalScoreOwned = finalScoreOwned;
    }

    public String getPointSpreadOwned() {
        return pointSpreadOwned;
    }

    public void setPointSpreadOwned(String pointSpreadOwned) {
        this.pointSpreadOwned = pointSpreadOwned;
    }

    public String getPointSpreadPlaying() {
        return pointSpreadPlaying;
    }

    public void setPointSpreadPlaying(String pointSpreadPlaying) {
        this.pointSpreadPlaying = pointSpreadPlaying;
    }

    public String getTeamNamePlaying() {
        return teamNamePlaying;
    }

    public void setTeamNamePlaying(String teamNamePlaying) {
        this.teamNamePlaying = teamNamePlaying;
    }

    public double getFinalScorePlaying() {
        return finalScorePlaying;
    }

    public void setFinalScorePlaying(int finalScorePlaying) {
        this.finalScorePlaying = finalScorePlaying;
    }

    public String getTeamThatCovered() {
        return teamThatCovered;
    }

    public void setTeamThatCovered(String teamThatCovered) {
        this.teamThatCovered = teamThatCovered;
    }

    public double getCoveredBy() {
        return coveredBy;
    }

    public void setCoveredBy(double coveredBy) {
        this.coveredBy = coveredBy;
    }

    public double getTeamOwnedNewValue() {
        return teamOwnedNewValue;
    }

    public void setTeamOwnedNewValue(double teamOwnedNewValue) {
        this.teamOwnedNewValue = teamOwnedNewValue;
    }

    public double getStartingValue() {
        return startingValue;
    }

    public void setStartingValue(double startingValue) {
        this.startingValue = startingValue;
    }

    @Override
    public String toString() {
        return "CalculatorDetail{" +
                "teamNameOwned='" + teamNameOwned + '\'' +
                ", finalScoreOwned=" + finalScoreOwned +
                ", pointSpreadOwned='" + pointSpreadOwned + '\'' +
                ", pointSpreadPlaying='" + pointSpreadPlaying + '\'' +
                ", teamNamePlaying='" + teamNamePlaying + '\'' +
                ", finalScorePlaying=" + finalScorePlaying +
                ", teamThatCovered='" + teamThatCovered + '\'' +
                ", coveredBy='" + coveredBy + '\'' +
                ", teamOwnedNewValue=" + teamOwnedNewValue +
                ", startingValue=" + startingValue +
                '}';
    }
}