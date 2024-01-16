package com.univ.stats_ms.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about team statistics")
public class TeamStats {

    @ApiModelProperty(notes = "Unique identifier for the team", required = true, value = "team1")
    private String teamId;

    @ApiModelProperty(notes = "Number of matches played by the team")
    private int matchesPlayed;

    @ApiModelProperty(notes = "Number of wins by the team")
    private int wins;

    @ApiModelProperty(notes = "Number of draws by the team")
    private int draws;

    @ApiModelProperty(notes = "Number of losses by the team")
    private int losses;

    @ApiModelProperty(notes = "Number of goals scored by the team")
    private int goalsFor;

    @ApiModelProperty(notes = "Number of goals conceded by the team")
    private int goalsAgainst;

    // Constructors, Getter and Setter methods

    public TeamStats() {
        // Default constructor
    }

    public TeamStats(String teamId, int matchesPlayed, int wins, int draws, int losses, int goalsFor, int goalsAgainst) {
        this.teamId = teamId;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    // toString method for debugging or logging

    @Override
    public String toString() {
        return "TeamStats{" +
                "teamId='" + teamId + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", wins=" + wins +
                ", draws=" + draws +
                ", losses=" + losses +
                ", goalsFor=" + goalsFor +
                ", goalsAgainst=" + goalsAgainst +
                '}';
    }
}
