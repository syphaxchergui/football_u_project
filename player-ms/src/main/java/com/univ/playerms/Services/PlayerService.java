package com.univ.playerms.Services;

import com.univ.playerms.Models.Player;
import com.univ.playerms.Models.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private static List<Player> playerList = new ArrayList<>();

    static {
        playerList.add(new Player("John Doe", 25, Position.DEFENDER, "TeamA"));
        playerList.add(new Player("Jane Smith", 22, Position.MIDFIELDER, "TeamA"));
        playerList.add(new Player("Bob Johnson", 30, Position.GOALKEEPER, "TeamC"));
    }

    public Optional<Player> getPlayerById(String id) {
        return playerList.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst();
    }

    public List<Player> getAllPlayers() {
        return playerList;
    }

    public List<Player> getAllPlayersByTeam(String team) {
        return playerList.stream()
                .filter(player -> player.getTeam().equals(team))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerList.add(player);
        return player;
    }

    public Player updatePlayer(String id, Player updatedPlayer) {
        for (Player player : playerList) {
            if (player.getId().equals(id)) {
                player.setName(updatedPlayer.getName());
                player.setAge(updatedPlayer.getAge());
                // Update other fields if necessary
                return player;
            }
        }
        return null;
    }

    public void deletePlayer(String id) {
        playerList.removeIf(player -> player.getId().equals(id));
    }


}
