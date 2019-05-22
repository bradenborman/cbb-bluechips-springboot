package com.Borman.cbbbluechips.models.SportsDataAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SportsDataTeam {

    @JsonProperty("TeamID")
    private Integer teamId;
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Active")
    private Boolean active;
    @JsonProperty("School")
    private String school;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ApRank")
    private String apRank;
    @JsonProperty("Wins")
    private Integer wins;
    @JsonProperty("Losses")
    private Integer losses;
    @JsonProperty("ConferenceWins")
    private Integer conferenceWins;
    @JsonProperty("ConferenceLosses")
    private Integer conferenceLosses;
    @JsonProperty("GlobalTeamID")
    private Long globalTeamId;
    @JsonProperty("ConferenceID")
    private Integer conferenceId;
    @JsonProperty("Conference")
    private String conference;
    @JsonProperty("TeamLogoUrl")
    private String teamLogoUrl;
    @JsonProperty("ShortDisplayName")
    private String shortDisplayName;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApRank() {
        return apRank;
    }

    public void setApRank(String apRank) {
        this.apRank = apRank;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getConferenceWins() {
        return conferenceWins;
    }

    public void setConferenceWins(Integer conferenceWins) {
        this.conferenceWins = conferenceWins;
    }

    public Integer getConferenceLosses() {
        return conferenceLosses;
    }

    public void setConferenceLosses(Integer conferenceLosses) {
        this.conferenceLosses = conferenceLosses;
    }

    public Long getGlobalTeamId() {
        return globalTeamId;
    }

    public void setGlobalTeamId(Long globalTeamId) {
        this.globalTeamId = globalTeamId;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getTeamLogoUrl() {
        return teamLogoUrl;
    }

    public void setTeamLogoUrl(String teamLogoUrl) {
        this.teamLogoUrl = teamLogoUrl;
    }

    public String getShortDisplayName() {
        return shortDisplayName;
    }

    public void setShortDisplayName(String shortDisplayName) {
        this.shortDisplayName = shortDisplayName;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write SportsDataTeam as string", e);
        }
    }

}
