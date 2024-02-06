package com.csmanager.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PlayerCreator {
    private Queue<Player> allPlayers = new LinkedList<>();

    private String[] names = {"Niko", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko"};

    public PlayerCreator() {
        for (int i = 0; i < 6; i++) {
            PotentialScope potentialScope;
            if (i < 3) {
                potentialScope = PotentialScope.NOOB;
            } else if (i < 5) {
                potentialScope = PotentialScope.KOX;
            } else {
                potentialScope = PotentialScope.PRO;
            }
            Player player = new Player(names[i], potentialScope);
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
