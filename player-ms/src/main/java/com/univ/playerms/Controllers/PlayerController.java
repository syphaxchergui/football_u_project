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

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/players")
@Api(tags = "Player MS", description = "MS for managing football players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get player by ID", notes = "Returns details of a player based on ID")
    @HystrixCommand(fallbackMethod = "fallbackGetPlayerById")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        return ResponseEntity.ok(playerService.getPlayerById(id).orElse(null));
    }

    @GetMapping("/team/{team}")
    @ApiOperation(value = "Get players by Team", notes = "Returns list of players based on team")
    @HystrixCommand(fallbackMethod = "fallbackGetPlayersByTeam")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable String team) {
        return ResponseEntity.ok(playerService.getAllPlayersByTeam(team));
    }

    @GetMapping
    @ApiOperation(value = "Get all players", notes = "Returns a list of all football players")
    @HystrixCommand(fallbackMethod = "fallbackGetAllPlayers")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @PostMapping
    @ApiOperation(value = "Add a new player", notes = "Creates a new football player")
    @HystrixCommand(fallbackMethod = "fallbackAddPlayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.addPlayer(player));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update player", notes = "Updates details of an existing football player")
    @HystrixCommand(fallbackMethod = "fallbackUpdatePlayer")
    public ResponseEntity<Player> updatePlayer(@PathVariable String id, @RequestBody Player updatedPlayer) {
        return ResponseEntity.ok(playerService.updatePlayer(id, updatedPlayer));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete player", notes = "Deletes a football player based on ID")
    @HystrixCommand(fallbackMethod = "fallbackDeletePlayer")
    public ResponseEntity<String> deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Player deleted successfully");
    }

    // Fallback methods

    private ResponseEntity<Player> fallbackGetPlayerById(String id) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

    private ResponseEntity<List<Player>> fallbackGetPlayersByTeam(String team) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    private ResponseEntity<List<Player>> fallbackGetAllPlayers() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    private ResponseEntity<Player> fallbackAddPlayer(Player player) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new Player());
    }

    private ResponseEntity<Player> fallbackUpdatePlayer(String id, Player updatedPlayer) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new Player());
    }

    private ResponseEntity<String> fallbackDeletePlayer(String id) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service Unavailable");
    }
}
