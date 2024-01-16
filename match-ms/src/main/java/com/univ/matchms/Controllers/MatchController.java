package com.univ.matchms.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.univ.matchms.Models.Match;
import com.univ.matchms.Services.MatchService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/matches")
@Api(tags = "Match MS", description = "MS for managing football matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    Environment environment;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get match by ID", notes = "Returns details of a football match based on ID")
    @HystrixCommand(fallbackMethod = "fallbackGetMatchById")
    public ResponseEntity<Match> getMatchById(@ApiParam(value = "Match ID", required = true) @PathVariable String id) {
        return ResponseEntity.ok(matchService.getMatchById(id).orElse(null));
    }

    @GetMapping("/test")
    public String getPort () {
        return environment.getProperty("default.server.port");
    }

    @GetMapping
    @ApiOperation(value = "Get all matches", notes = "Returns a list of all football matches")
    @HystrixCommand(fallbackMethod = "fallbackGetAllMatches")
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    @PostMapping
    @ApiOperation(value = "Add a new match", notes = "Creates a new football match")
    @HystrixCommand(fallbackMethod = "fallbackAddMatch")
    public ResponseEntity<Match> addMatch(@ApiParam(value = "Match details", required = true) @RequestBody Match match) {
        Match addedMatch = matchService.addMatch(match);
        return ResponseEntity.ok(addedMatch);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update match", notes = "Updates details of an existing football match")
    @HystrixCommand(fallbackMethod = "fallbackUpdateMatch")
    public ResponseEntity<Match> updateMatch(
            @ApiParam(value = "Match ID", required = true) @PathVariable String id,
            @ApiParam(value = "Updated match details", required = true) @RequestBody Match updatedMatch) {
        Match updated = matchService.updateMatch(id, updatedMatch);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete match", notes = "Deletes a football match based on ID")
    @HystrixCommand(fallbackMethod = "fallbackDeleteMatch")
    public ResponseEntity<?> deleteMatch(@ApiParam(value = "Match ID", required = true) @PathVariable String id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok().build();
    }

    // Fallback methods

    private ResponseEntity<Match> fallbackGetMatchById(String id) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

    private ResponseEntity<List<Match>> fallbackGetAllMatches() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    private ResponseEntity<Match> fallbackAddMatch(Match match) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

    private ResponseEntity<Match> fallbackUpdateMatch(String id, Match updatedMatch) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

    private ResponseEntity<?> fallbackDeleteMatch(String id) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service Unavailable");
    }
}
