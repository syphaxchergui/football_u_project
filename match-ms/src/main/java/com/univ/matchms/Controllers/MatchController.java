package com.univ.matchms.Controllers;

import com.univ.matchms.Models.Match;
import com.univ.matchms.Services.MatchService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@Api(tags = "Match MS", description = "MS for managing football matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get match by ID", notes = "Returns details of a football match based on ID")
    public Match getMatchById(@ApiParam(value = "Match ID", required = true) @PathVariable String id) {
        return matchService.getMatchById(id).orElse(null);
    }

    @GetMapping
    @ApiOperation(value = "Get all matches", notes = "Returns a list of all football matches")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping
    @ApiOperation(value = "Add a new match", notes = "Creates a new football match")
    public Match addMatch(@ApiParam(value = "Match details", required = true) @RequestBody Match match) {
        return matchService.addMatch(match);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update match", notes = "Updates details of an existing football match")
    public Match updateMatch(
            @ApiParam(value = "Match ID", required = true) @PathVariable String id,
            @ApiParam(value = "Updated match details", required = true) @RequestBody Match updatedMatch) {
        return matchService.updateMatch(id, updatedMatch);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete match", notes = "Deletes a football match based on ID")
    public void deleteMatch(@ApiParam(value = "Match ID", required = true) @PathVariable String id) {
        matchService.deleteMatch(id);
    }
}
