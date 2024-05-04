package com.csmanager.model.player.player.creatingStrategy;

import com.csmanager.model.player.player.Player;
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
        Player player = proCreatingStrategy.createPlayer();
        System.out.println(player.toString());
    }

}
