package com.csmanager.model.player.creatingStrategy;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.performance.Difficulty;
import com.csmanager.utils.JsonReader;

import java.util.LinkedList;
import java.util.Queue;

public class ProCreatingStrategy implements PlayerCreatingStrategy {
    private final Queue<Player> players = new LinkedList<>();

    public ProCreatingStrategy() {
        players.addAll(JsonReader.read("ProPlayers.json"));
    }

    @Override
    public Player createPlayer() {
        return players.remove();
    }


    public static void main(String[] args) {
        ProCreatingStrategy proCreatingStrategy = new ProCreatingStrategy();
        System.out.println(proCreatingStrategy.createPlayer());
        Player player = new Player();
    }

}
