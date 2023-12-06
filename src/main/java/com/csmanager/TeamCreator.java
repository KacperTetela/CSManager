package com.csmanager;

import java.util.ArrayList;
import java.util.List;

public class TeamCreator {
    private List<Team> teams = new ArrayList<>();
    private PlayerCreator playerCreator;

    public TeamCreator(PlayerCreator playerCreator) {
        this.playerCreator = playerCreator;
        playerCreator.getPlayers();

        for (int i = 0 ; i < 2; i++) {
            Team team = new Team();
            teams.add(team);
            for (int j = 0; j < 5; j++) {
                teams.get(i).addPlayer(playerCreator.getPlayers().get(j+(i*5)));
            }
        }
        System.out.println(teams.get(0).toString());
        System.out.println(teams.get(1).toString());
    }

}