package com.csmanager.model.lineup;

import com.csmanager.model.Match;
import com.csmanager.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Lineup {
    private List<Player> players = new ArrayList<>();
    private Player leader;

    public Lineup() {
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

    public double getLineUpSkillLevel(Match match) {
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
        players.forEach(lineupPlayer -> lineupPlayer.trainPlayer());
    }

    public void closeLineup() {
        for (Player player : players) {
            player.setBusy(false);
        }
    }
}
