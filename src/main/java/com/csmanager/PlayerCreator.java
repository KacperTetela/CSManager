package com.csmanager;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreator {
    private List<Player> players = new ArrayList<>();
    private String[] names = {"Niko", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko"};

    public PlayerCreator() {
        for (int i = 0; i < 10; i++) {
            Player player = new Player(names[i], i, i);
            players.add(player);
        }
    }

    protected void listPrinter() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
    }

    protected Player getFreePlayer() {
        Player player = null;
        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            if (currentPlayer != null && !currentPlayer.getName().isEmpty()) {
                player = currentPlayer;
                return player;
            }
        }

        if (player == null) {
            throw new RuntimeException("free player not found");
        }
        return player;
    }


    protected void deletePlayer(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                players.get(i).setName("");
                players.get(i).setExperience(0);
                players.get(i).setSkillLevel(0);
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

}
