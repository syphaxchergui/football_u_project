package com.univ.playerms.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.univ.playerms.Models.Player;
import com.univ.playerms.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@RestController
@RequestMapping("/players")
@Api(tags = "Player MS", description = "MS for managing football players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get player by ID", notes = "Returns details of a player based on ID")
    public Player getPlayerById(@PathVariable String id) {
        return playerService.getPlayerById(id).orElse(null);
    }

    @GetMapping("/team/{team}")
    @ApiOperation(value = "Get players by Team", notes = "Returns list of players based on team")
    public List<Player> getPlayersByTeam(@PathVariable String team) {
        return playerService.getAllPlayersByTeam(team);
    }

    @GetMapping
    @ApiOperation(value = "Get all players", notes = "Returns a list of all football players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    @ApiOperation(value = "Add a new player", notes = "Creates a new football player")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update player", notes = "Updates details of an existing football player")
    public Player updatePlayer(@PathVariable String id, @RequestBody Player updatedPlayer) {
        return playerService.updatePlayer(id, updatedPlayer);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete player", notes = "Deletes a football player based on ID")
    public void deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
    }

    private ResponseEntity<?> fallbackMethod() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service Unavailable");
    }
}
