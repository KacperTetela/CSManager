package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.PlayerBuilder;
import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerStatsScope;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PlayerFactory {
    private Queue<Player> allPlayers = new LinkedList<>();

    private String[] names = {"Neo", "PashaBiceps", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko", "device", "Magisk", "Xyp9x"};

    public PlayerFactory() {
        for (int i = 0; i < 6; i++) {
            PlayerStatsScope playerStatsScope;
            if (i < 3) {
                playerStatsScope = PlayerStatsScope.NOOB;
            } else if (i < 5) {
                playerStatsScope = PlayerStatsScope.KOX;
            } else {
                playerStatsScope = PlayerStatsScope.PRO;
            }
            PlayerBuilder playerBuilder = new PlayerBuilder();
            playerBuilder.name(names[i])
                    .playerStatsScope(playerStatsScope);
            Player player = playerBuilder.build();
            allPlayers.add(player);
        }
    }

    public List<Player> getPlayers(int numberOfPlayers) {
        if (allPlayers.size() < numberOfPlayers) {
            throw new IllegalArgumentException("Not enough players");
        }
        List<Player> players = new LinkedList<>();
        IntStream.range(0, numberOfPlayers)
                .forEach(i -> players.add(allPlayers.poll()));
        return players;
    }
}
