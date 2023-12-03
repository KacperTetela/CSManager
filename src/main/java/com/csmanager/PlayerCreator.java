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
                break;
            }
        }

        if (player == null) {
            System.out.println("Not Exist");
            //return new Player("Not Exist",1,1);
        }

        return player;
    }


    protected void deletePlayer(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                players.get(i).setName("");
                players.get(i).setExperience(0);
                players.get(i).setFaceitRanking(0);
            }
        }
    }

}
