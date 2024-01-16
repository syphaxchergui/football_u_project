package com.univ.stats_ms.Controllers;

import com.univ.stats_ms.Models.TeamStats;
import com.univ.stats_ms.Models.PlayerStats;
import com.univ.stats_ms.Services.StatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(tags = "Statistics API", description = "Endpoints for managing football statistics")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //Route to test Load balancing
    @GetMapping("/matches")
    public String testGetMatches () {
        return this.restTemplate.getForObject("http://match-service/matches/test", String.class);
    }

    @GetMapping("/team-stats/{teamId}")
    @ApiOperation(value = "Get team statistics", notes = "Returns statistics for a team for the season.")
    @ApiParam(name = "teamId", value = "Unique identifier for the team", defaultValue = "team1")
    public ResponseEntity<TeamStats> getTeamStats(@PathVariable String teamId) {
        TeamStats teamStats = statsService.getTeamStats(teamId);

        if (teamStats != null) {
            return new ResponseEntity<>(teamStats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/player-stats/{playerId}")
    @ApiOperation(value = "Get player statistics", notes = "Returns statistics for a player for the season.")
    @ApiParam(name = "playerId", value = "Unique identifier for the player", defaultValue = "player1")
    public ResponseEntity<PlayerStats> getPlayerStats(@PathVariable String playerId) {
        PlayerStats playerStats = statsService.getPlayerStats(playerId);

        if (playerStats != null) {
            return new ResponseEntity<>(playerStats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
