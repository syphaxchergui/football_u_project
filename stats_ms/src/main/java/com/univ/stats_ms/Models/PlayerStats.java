package com.univ.stats_ms.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about player statistics")
public class PlayerStats {

    @ApiModelProperty(notes = "Unique identifier for the player", required = true, value = "player1")
    private String playerId;

    @ApiModelProperty(notes = "Number of goals scored by the player")
    private int goals;

    @ApiModelProperty(notes = "Number of assists by the player")
    private int assists;

    @ApiModelProperty(notes = "Number of matches played by the player")
    private int numberOfMatchesPlayed;

    @ApiModelProperty(notes = "Number of yellow cards received by the player")
    private int yellowCards;

    @ApiModelProperty(notes = "Number of red cards received by the player")
    private int redCards;

    // Constructors, Getter and Setter methods

    public PlayerStats() {
        // Default constructor
    }

    public PlayerStats(String playerId, int goals, int assists, int numberOfMatchesPlayed, int yellowCards, int redCards) {
        this.playerId = playerId;
        this.goals = goals;
        this.assists = assists;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        // Set other relevant statistics fields
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    // toString method for debugging or logging

    @Override
    public String toString() {
        return "PlayerStats{" +
                "playerId='" + playerId + '\'' +
                ", goals=" + goals +
                ", assists=" + assists +
                ", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                '}';
    }
}
