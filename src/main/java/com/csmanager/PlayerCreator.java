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

}
