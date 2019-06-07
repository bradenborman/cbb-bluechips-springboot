package com.Borman.cbbbluechips.models.SportsDataAPI;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SportsDataGamesToday {

    @JsonProperty("Season")
    private String season;

    @JsonProperty("AwayTeam")
    private String awayTeam;

    @JsonProperty("HomeTeam")
    private String homeTeam;

    @JsonProperty("HomeTeamID")
    private String homeTeamId;

    @JsonProperty("AwayTeamID")
    private String awayTeamId;

    @JsonProperty("DateTime")
    private String dateTime;

    @JsonProperty("PointSpread")
    private String pointSpread;

    @JsonProperty("Round")
    private String round;


    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPointSpread() {
        return pointSpread;
    }

    public void setPointSpread(String pointSpread) {
        this.pointSpread = pointSpread;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
