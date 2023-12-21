package com.csmanager;

import com.csmanager.playermodel.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PlayerCreator {
    private Queue<Player> allPlayers = new LinkedList<>();

    private String[] names = {"Niko", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko"};

    public PlayerCreator() {
        for (int i = 0; i < 10; i++) {
            Player player = new Player(names[i]);
            allPlayers.add(player);
        }
    }

    public List<Player> getPlayers(int numberOfPlayers) {
        if (allPlayers.size() < numberOfPlayers) {
            throw new IllegalArgumentException("Not enough players");
        }
        List<Player> players = new LinkedList<>();
        IntStream.range(0,numberOfPlayers)
                .forEach(i -> players.add(allPlayers.poll()));

        //to samo co wyzej
        /*for (int i = 0; i < numberOfPlayers; i++) {
            players.add(allPlayers.poll());
        }*/
        return players;
    }
}
