package com.csmanager.model;

import com.csmanager.utils.Utils;

import java.util.List;
import java.util.Optional;

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
        return "Team: " + name +
                "\nmoney=" + money +
                "\nPlayers:"+
                Utils.createListDisplay(players);
    }

    public Optional<Player> findPlayerByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
