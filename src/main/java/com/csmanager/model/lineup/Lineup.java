package com.csmanager.model.lineup;

import java.util.ArrayList;
import java.util.List;

public class Lineup {
    private List<LineupPlayer> players = new ArrayList<>();
    private LineupPlayer leader;

    public Lineup() {
    }

    public void addPlayer(LineupPlayer player) {
        if (player != null)
            this.players.add(player);
    }

    public void addPlayers(List<LineupPlayer> players) {
        for (LineupPlayer player : players) {
            addPlayer(player);
        }
    }

    @Override
    public String toString() {
        return "LineUp{" +
                "players=" + players +
                '}';
    }

    public double getLineUpSkillLevel() {
        double teamSkillLevel = 0;
        for (int i = 0; i < players.size(); i++) {
            teamSkillLevel += players.get(i).getSkillLevel();
        }
        return teamSkillLevel;
    }

    public List<LineupPlayer> getPlayers() {
        return players;
    }

    public void trainPlayers() {
        players.forEach(lineupPlayer -> lineupPlayer.trainPlayer());
    }

    public void closeLineup() {
        for (LineupPlayer player : players) {
            player.getPlayer().setBusy(false);
        }
    }
}
