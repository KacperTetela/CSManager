package com.csmanager;

import com.csmanager.playermodel.Player;

import java.util.ArrayList;
import java.util.List;

public class LineUp {
    private List<Player> players = new ArrayList<>();

    public LineUp() {
    }

    // Metoda do dodawania pojedynczego gracza
    public void addPlayer(Player player) {
        if (player != null)
            this.players.add(player);
    }

    // Metoda do dodawania listy graczy
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

/*    public int getTeamSkillLevel() {
        int teamSkillLevel = 0;
        for (int i = 0; i < players.size(); i++) {
            teamSkillLevel += players.get(i).getSkillLevel();
        }
        return teamSkillLevel;
    }*/

}
