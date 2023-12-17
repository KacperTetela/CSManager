package com.csmanager.carrer.startingLineUp;

import com.csmanager.carrer.startingLineUp.TSideRoles.TSideRole;
import com.csmanager.carrer.startingLineUp.TSideRoles.TSideRoles;
import com.csmanager.playermodel.Player;

public class StartingLineUp {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    TSideRoles tSideRoles = new TSideRoles(TSideRole.LURKER, TSideRole.LURKER, TSideRole.RIFLER, TSideRole.RIFLER, TSideRole.AWPER, TSideRole.LEADER);

    public StartingLineUp(Player player1, Player player2, Player player3, Player player4, Player player5) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
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
