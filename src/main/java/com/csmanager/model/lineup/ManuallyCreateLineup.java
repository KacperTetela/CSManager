package com.csmanager.model.lineup;

import com.csmanager.model.player.Player;
import com.csmanager.model.Team;
import com.csmanager.utils.Utils;

import java.util.Optional;
import java.util.Scanner;

public class ManuallyCreateLineup {
    private final Team myTeam;
    private Lineup lineUp;

    public ManuallyCreateLineup(Team myTeam) {
        this.myTeam = myTeam;
        this.lineUp = new Lineup();
    }

    public void createLineUp() {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String name = Utils.askAboutString("Write name of players which you want to add to your lineup");

            Optional<Player> playerOptional = myTeam.findPlayerNotBusyByName(name);
            if (playerOptional.isEmpty()) {
                System.out.println("Player not found or Player already taken");
                i--;
                continue;
            }

            System.out.println("Select roles T for " + name + "\n rifler=0 lurker=1 awp=2");
            int tRoleVal = scanner.nextInt();
            System.out.println("Select roles CT for " + name + "\n anchor=0 rotator=1 awp=2");
            int ctRoleVal = scanner.nextInt();

            RoleType tRoleType;
            if (tRoleVal == 0) {
                tRoleType = RoleType.RIFLER;
            } else if (tRoleVal == 1) {
                tRoleType = RoleType.LURKER;
            } else {
                tRoleType = RoleType.AWPER;
            }

            RoleType ctRoleType;
            if (ctRoleVal == 0) {
                ctRoleType = RoleType.ANCHOR;
            } else if (ctRoleVal == 1) {
                ctRoleType = RoleType.ROTATOR;
            } else {
                ctRoleType = RoleType.AWPER;
            }
            Player player = playerOptional.get();
            player.setRoles(ctRoleType, tRoleType);
            lineUp.addPlayer(player);
            player.setBusy(true);
        }
    }

    public Lineup getLineUp() {
        return lineUp;
    }
}

/*
* Match + playera + role
*  = strategia
*
*
* */
