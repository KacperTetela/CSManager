package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.csmanager.utils.JsonReader;

import java.util.LinkedList;
import java.util.Queue;

public class ProCreatingStrategy implements PlayerCreatingStrategy {
    private final Queue<Player> players = new LinkedList<>();

    public ProCreatingStrategy() {
        players.addAll(JsonReader.read());
    }

    @Override
    public Player createPlayer() {
        return players.remove();
    }
}
