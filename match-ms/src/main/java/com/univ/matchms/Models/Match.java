package com.univ.matchms.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.UUID;

@ApiModel(description = "Details about a football match")
public class Match {

    @ApiModelProperty(notes = "Unique identifier for the match")
    private String id;

    @ApiModelProperty(notes = "The home team")
    private String homeTeam;

    @ApiModelProperty(notes = "The away team")
    private String awayTeam;

    @ApiModelProperty(notes = "Start time of the match")
    private String startTime;

    @ApiModelProperty(notes = "Score of the home team")
    private int homeTeamScore;

    @ApiModelProperty(notes = "Score of the away team")
    private int awayTeamScore;

    // Constructors, Getter and Setter methods

    public Match() {
        this.id = generateUniqueId();
    }

    public Match(String homeTeam, String awayTeam, String startTime, int homeTeamScore, int awayTeamScore) {
        this.id = generateUniqueId();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    // Helper method to generate a unique ID (for simplicity, you can use a counter)
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
