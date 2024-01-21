package com.csmanager.carrer.startingLineUp;

import java.util.ArrayList;
import java.util.List;

public class LineUp {
    private List<LineUpPlayer> players = new ArrayList<>();
    private LineUpPlayer leader;

    public LineUp() {
    }

    public void addPlayer(LineUpPlayer player) {
        if (player != null)
            this.players.add(player);
    }

    public void addPlayers(List<LineUpPlayer> players) {
        for (LineUpPlayer player : players) {
            addPlayer(player);
        }
    }

    @Override
    public String toString() {
        return "LineUp{" +
                "players=" + players +
                '}';
    }

    public int getLineUpSkillLevel() {
        int teamSkillLevel = 0;
        for (int i = 0; i < players.size(); i++) {
            teamSkillLevel += players.get(i).getSkillLevel();
        }
        return teamSkillLevel;
    }
}
