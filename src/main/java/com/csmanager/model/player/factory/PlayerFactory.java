package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PlayerFactory {
    private Queue<Player> allPlayers = new LinkedList<>();

    private String[] names = {"Neo", "PashaBiceps", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko", "device", "Magisk", "Xyp9x"};

    public PlayerFactory() {
        setUpFactory();
    }

    private void setUpFactory() {
        for (int i = 0; i < 6; i++) {
            allPlayers.add(createPlayerByIter(i));
        }
    }

    private Player createPlayerByIter(int i) {
        PlayerBuilder playerBuilder;
        if (i < 3) {
            playerBuilder = new PlayerBuilderNoob();
        } else if (i < 5) {
            playerBuilder = new PlayerBuilderKox();
        } else {
            playerBuilder = new PlayerBuilderNoob();
        }
        playerBuilder.name(names[i])
                .playerStatsScope();
        Player player = playerBuilder.build();
        return player;
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