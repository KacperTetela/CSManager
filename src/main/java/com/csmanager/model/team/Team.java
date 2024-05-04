package com.csmanager.model.team;

import com.csmanager.model.player.player.Player;
import com.csmanager.utils.Utils;

import java.util.List;
import java.util.Optional;

public class Team {
    private String name;
    private List<Player> players;
    private int money;
    private Player leader;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.money = 1000;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money) {
        this.money -= money;
    }

    @Override
    public String toString() {
        return "\nTeam: " + name +
                "\nmoney=" + money +
                "\nPlayers:\n"+
                Utils.createListDisplay(players);
    }

    public Optional<Player> findPlayerNotBusyByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equalsIgnoreCase(name) && !player.isBusy())
                .findFirst();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
