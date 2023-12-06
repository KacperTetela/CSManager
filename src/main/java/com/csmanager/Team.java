package com.csmanager;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players = new ArrayList<>();
    private PlayerCreator playerCreator;

    public Team() {
    }

    // Metoda do dodawania pojedynczego gracza
    public void addPlayer(Player player) {
        if (player != null)
            this.players.add(player);
    }

    // Metoda do dodawania listy graczy
    public void addPlayers(List<Player> players) {
        for (Player player : players) {
            addPlayer(player);
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                '}';
    }

}
