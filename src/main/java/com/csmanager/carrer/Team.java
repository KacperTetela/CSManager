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

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", money=" + money +
                '}';
    }

    public List<Player> getPlayers() {
        return players;
    }
}
