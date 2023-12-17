package com.csmanager.carrer;

import com.csmanager.LineUp;
import com.csmanager.carrer.startingLineUp.StartingLineUp;
import com.csmanager.playermodel.Player;

import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private int money;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.money = 1000;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money) {
        this.money -= money;
    }

    //setStartingLineUp
    public void setStartingLineUp(Player player1, Player player2, Player player3, Player player4, Player player5) {
        StartingLineUp startingLineUp = new StartingLineUp(player1, player2, player3, player4, player5);

    }
}
