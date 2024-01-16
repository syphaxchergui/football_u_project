package com.univ.teamms.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.univ.teamms.Models.Team;
import com.univ.teamms.Services.TeamService;
import io.swagger.annotations.*;
import org.omg.CORBA.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@Api(tags = "Team MS", description = "MS for managing football teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get team by ID", notes = "Returns details of a team based on ID")
    public ResponseEntity<?> getTeamById(
            @ApiParam(value = "Team ID", required = true) @PathVariable String id) {
        return ResponseEntity.ok(teamService.getTeamById(id).orElse(null));
    }

    @GetMapping
    @ApiOperation(value = "Get all teams", notes = "Returns a list of all football teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @PostMapping
    @ApiOperation(value = "Add a new team", notes = "Creates a new football team")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Team Name", required = true, defaultValue = "New Team")
    })
    public ResponseEntity<Team> addTeam(
            @ApiParam(value = "Team details", required = true) @RequestBody Team team) {
        Team addedTeam = teamService.addTeam(team);
        return ResponseEntity.ok(addedTeam);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update team", notes = "Updates details of an existing football team")
    public ResponseEntity<Team> updateTeam(
            @ApiParam(value = "Team ID", required = true) @PathVariable String id,
            @ApiParam(value = "Updated team details", required = true) @RequestBody Team updatedTeam) {
        Team updated = teamService.updateTeam(id, updatedTeam);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete team", notes = "Deletes a football team based on ID")
    public ResponseEntity<?> deleteTeam(
            @ApiParam(value = "Team ID", required = true) @PathVariable String id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<?> fallbackMethod() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service Unavailable");
    }
}
