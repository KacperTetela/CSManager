package com.csmanager;

import com.csmanager.carrer.startingLineUp.Role;
import com.csmanager.playermodel.LineUpPlayer;
import com.csmanager.playermodel.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LineUp {
    private List<LineUpPlayer> players = new ArrayList<>();
    private LineUpPlayer leader;



    public LineUp() {
    }

    // Metoda do dodawania pojedynczego gracza
    public void addPlayer(LineUpPlayer player) {
        if (player != null)
            this.players.add(player);
    }

    // Metoda do dodawania listy graczy
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

/*    public int getTeamSkillLevel() {
        int teamSkillLevel = 0;
        for (int i = 0; i < players.size(); i++) {
            teamSkillLevel += players.get(i).getSkillLevel();
        }
        return teamSkillLevel;
    }*/

}
