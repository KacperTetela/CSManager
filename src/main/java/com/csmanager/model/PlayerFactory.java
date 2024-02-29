package com.csmanager.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PlayerFactory {
    private Queue<Player> allPlayers = new LinkedList<>();

    private String[] names = {"Niko", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko"};

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
            Player player = new Player(names[i], playerStatsScope);
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
