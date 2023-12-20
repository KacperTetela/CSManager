package com.csmanager.carrer.startingLineUp;

import com.csmanager.carrer.Team;
import com.csmanager.carrer.startingLineUp.TSideRoles.TSideRole;
import com.csmanager.carrer.startingLineUp.TSideRoles.TSideRoles;
import com.csmanager.playermodel.Player;

public class StartingLineUp {
    private Team team;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    TSideRoles tSideRoles = new TSideRoles(TSideRole.LURKER, TSideRole.LURKER, TSideRole.RIFLER, TSideRole.RIFLER, TSideRole.AWPER, TSideRole.LEADER);

    public StartingLineUp(Team team) {
        this.team = team;
        //wypisac graczy i zapytac uzytkownika ktorych graczy chce miec w lineupie
        this.player1 = team.getPlayers().get(0);
        this.player2 = team.getPlayers().get(1);
        this.player3 = team.getPlayers().get(2);
        this.player4 = team.getPlayers().get(3);
        this.player5 = team.getPlayers().get(4);

    }

    @Override
    public String toString() {
        return "StartingLineUp{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", player3=" + player3 +
                ", player4=" + player4 +
                ", player5=" + player5 +
                '}';
    }
}
