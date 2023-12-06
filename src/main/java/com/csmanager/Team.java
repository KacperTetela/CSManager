package com.csmanager;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players = new ArrayList<>();
    private PlayerCreator playerCreator;
    private int teamScore;

    public Team() {
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
        return "Team{" +
                "players=" + players +
                '}';
    }

    public int getTeamSkillLevel() {
        int teamSkillLevel = 0;
        for (int i = 0; i < players.size(); i++) {
            teamSkillLevel += players.get(i).getSkillLevel();
        }
        return teamSkillLevel;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

}
