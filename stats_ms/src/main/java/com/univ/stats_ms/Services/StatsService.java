package com.univ.stats_ms.Services;

import com.univ.stats_ms.Models.TeamStats;
import com.univ.stats_ms.Models.PlayerStats;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatsService {

    private static List<TeamStats> teamStatsList = new ArrayList<>();
    private static List<PlayerStats> playerStatsList = new ArrayList<>();

    // Initialize static lists with example data
    static {
        // Example TeamStats
        TeamStats teamStats1 = new TeamStats("team1", 10, 7, 2, 1, 20, 10);
        TeamStats teamStats2 = new TeamStats("team2", 12, 8, 3, 1, 25, 15);

        teamStatsList.add(teamStats1);
        teamStatsList.add(teamStats2);

        // Example PlayerStats
        PlayerStats playerStats1 = new PlayerStats("player1", 15, 5, 20, 2, 0);
        PlayerStats playerStats2 = new PlayerStats("player2", 10, 8, 18, 1, 1);

        playerStatsList.add(playerStats1);
        playerStatsList.add(playerStats2);
    }

    public TeamStats getTeamStats(String teamId) {
        return teamStatsList.stream()
                .filter(teamStats -> teamStats.getTeamId().equals(teamId))
                .findFirst()
                .orElse(null);
    }

    public PlayerStats getPlayerStats(String playerId) {
        return playerStatsList.stream()
                .filter(playerStats -> playerStats.getPlayerId().equals(playerId))
                .findFirst()
                .orElse(null);
    }
}