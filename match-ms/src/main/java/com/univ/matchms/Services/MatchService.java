package com.univ.matchms.Services;

import com.univ.matchms.Models.Match;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private static List<Match> matchList = new ArrayList<>();

    static {
        matchList.add(new Match("TeamA", "TeamB", LocalDateTime.now().toString(), 2, 1));
        matchList.add(new Match("TeamC", "TeamD", LocalDateTime.now().plusDays(1).toString(), 0, 0));
        matchList.add(new Match("TeamE", "TeamF", LocalDateTime.now().plusDays(2).toString(), 3, 2));
    }

    public Optional<Match> getMatchById(String id) {
        return matchList.stream()
                .filter(match -> match.getId().equals(id))
                .findFirst();
    }

    public List<Match> getAllMatches() {
        return matchList;
    }

    public Match addMatch(Match match) {
        matchList.add(match);
        return match;
    }

    public Match updateMatch(String id, Match updatedMatch) {
        for (Match match : matchList) {
            if (match.getId().equals(id)) {
                match.setHomeTeam(updatedMatch.getHomeTeam());
                match.setAwayTeam(updatedMatch.getAwayTeam());
                match.setStartTime(updatedMatch.getStartTime());
                match.setHomeTeamScore(updatedMatch.getHomeTeamScore());
                match.setAwayTeamScore(updatedMatch.getAwayTeamScore());
                return match;
            }
        }
        return null;
    }

    public void deleteMatch(String id) {
        matchList.removeIf(match -> match.getId().equals(id));
    }

    // Helper method to generate a unique ID (for simplicity, you can use a counter)
    private String generateUniqueId() {
        return Long.toString(System.currentTimeMillis()); // Use a proper ID generation strategy in a real application
    }
}
