package com.csmanager;

import com.csmanager.playermodel.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerCreator {
    private Queue<Player> allPlayers = new LinkedList<>();

    private String[] names = {"Niko", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko"};

    public PlayerCreator() {
        for (int i = 0; i < 10; i++) {
            Player player = new Player(names[i], i, i);
            allPlayers.add(player);
        }
    }

    protected void listPrinter() {
        for (Player player : allPlayers) {
            System.out.println(player);
        }
    }

    protected Player getFreePlayer() {
        if (allPlayers.isEmpty()) {
            throw new RuntimeException("free player not found");
        }
        return allPlayers.remove();
       /* Player player = null;
        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            if (currentPlayer != null && !currentPlayer.getName().isEmpty()) {
                player = currentPlayer;
                return player;
            }
        }


        return player;*/
    }


    protected void deletePlayer(String name) {
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.peek().getName().equals(name)) {
                allPlayers.remove(i);
            }
        }
    }

    public Queue<Player> getAllPlayers() {
        return allPlayers;
    }

}
