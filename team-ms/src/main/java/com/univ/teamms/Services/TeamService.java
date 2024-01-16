package com.univ.teamms.Services;

import com.univ.teamms.Models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {

    private static List<Team> teamList = new ArrayList<>();

    @Autowired
    PlayerService playerService;

    static {
        teamList.add(new Team("TeamA"));
        teamList.add(new Team("TeamB"));
        teamList.add(new Team("TeamC"));
        teamList.add(new Team("TeamE"));
        teamList.add(new Team("TeamF"));
        teamList.add(new Team("TeamD"));
    }

    public Optional<Map<String, Object>> getTeamById(String id) {

        Optional<Team> teamById = teamList.stream()
                .filter(team -> team.getId().equals(id))
                .findFirst();

        if (teamById.isPresent()) {
            Team team = teamById.get();
            System.out.println(team.getName());
            List<?> teamPlayers = playerService.getPlayersForTeam(team.getName());
            System.out.println(teamPlayers);

            Map<String, Object> result = new HashMap<>();
            result.put("team", team);
            result.put("players", teamPlayers);

            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public List<Team> getAllTeams() {
        return teamList;
    }

    public Team addTeam(Team team) {
        teamList.add(team);
        return team;
    }

    public Team updateTeam(String id, Team updatedTeam) {
        for (Team team : teamList) {
            if (team.getId().equals(id)) {
                team.setName(updatedTeam.getName());
                // Update other fields if necessary
                return team;
            }
        }
        return null;
    }

    public void deleteTeam(String id) {
        teamList.removeIf(team -> team.getId().equals(id));
    }

    // Helper method to generate a unique ID (for simplicity, you can use a counter)
}
