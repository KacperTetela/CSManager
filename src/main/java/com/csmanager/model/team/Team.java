package com.csmanager.model.team;

import com.csmanager.model.match.MatchRules;
import com.csmanager.model.player.player.Player;
import com.csmanager.model.shop.coachPerks.AbstractPerk;
import com.csmanager.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Team {
    private final String name;
    private final List<Player> players;
    private int money;
    private Player leader;
    private List<AbstractPerk> abstractPerks = new ArrayList<>();
    private static int statsVisibilityLevel = 0;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.money = 100;
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

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "\nTeam: " + name +
                "\nmoney: " + money +
                "\nPlayers:\n" +
                Utils.createListDisplay(players, statsVisibilityLevel);
    }

    public Optional<Player> findPlayerNotBusyByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equalsIgnoreCase(name) && !player.isBusy())
                .findFirst();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void buyPerk(AbstractPerk abstractPerk) {
        if (money >= abstractPerk.getPrice()) {
            removeMoney(abstractPerk.getPrice());
        } else {
            System.out.println("You do not have enough money!");
            return;
        }
        abstractPerks.add(abstractPerk);
        abstractPerk.turnOn();
    }

    public static void increaseStatsVisibility() {
        statsVisibilityLevel++;
    }

    public static int getStatsVisibilityLevel() {
        return statsVisibilityLevel;
    }
}