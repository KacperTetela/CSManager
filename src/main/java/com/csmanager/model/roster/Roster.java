package com.csmanager.model.roster;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.builder.Player;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private List<Player> players = new ArrayList<>();

    public Roster() {
    }

    public void addPlayer(Player player) {
        if (player != null)
            this.players.add(player);
    }

    public void addPlayers(List<Player> players) {
        for (Player player : players) {
            addPlayer(player);
        }
    }

    @Override
    public String toString() {
        return "LineUp{" +
                "players=" + players +
                '}';
    }

    public double getRosterSkillLevel(Match match) {
        double teamSkillLevel = 0;
        for (int i = 0; i < players.size(); i++) {
            teamSkillLevel += players.get(i).getSkill(match);
        }
        return teamSkillLevel;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void trainPlayers() {
        players.forEach(player -> player.trainPlayer());
    }

    public void closeRoster() {
        for (Player player : players) {
            player.setBusy(false);
        }
    }
}
