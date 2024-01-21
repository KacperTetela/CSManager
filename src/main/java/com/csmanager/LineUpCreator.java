package com.csmanager;

import com.csmanager.carrer.startingLineUp.LineUp;

import java.util.ArrayList;
import java.util.List;

public class LineUpCreator {
    private List<LineUp> lineUps = new ArrayList<>();
    private PlayerCreator playerCreator;

    public LineUpCreator(PlayerCreator playerCreator) {
        this.playerCreator = playerCreator;
        /*playerCreator.getAllPlayers();

        for (int i = 0 ; i < 2; i++) {
            LineUp lineUp = new LineUp();
            lineUps.add(lineUp);
            for (int j = 0; j < 5; j++) {
                lineUps.get(i).addPlayer(playerCreator.getAllPlayers().poll());
            }
        }
        System.out.println(lineUps.get(0).toString());
        System.out.println(lineUps.get(1).toString());*/
    }

    public List<LineUp> getTeams() {
        return lineUps;
    }

/*    public void createTeam() {
        Team team = new Team();
        team.setLineUp(lineUps.get(0));
        team.setMoney(50000);
        team.setName("Team1");
        team.setPlayers(lineUps.get(0).getPlayers());
        System.out.println(team.toString());
    }*/

}