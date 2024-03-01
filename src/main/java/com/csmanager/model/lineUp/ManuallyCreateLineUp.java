package com.csmanager.model.lineUp;

import com.csmanager.model.player.Player;
import com.csmanager.model.Team;
import com.csmanager.utils.Utils;

import java.util.Optional;
import java.util.Scanner;

public class ManuallyCreateLineUp {
    private final Team myTeam;
    private LineUp lineUp;

    public ManuallyCreateLineUp(Team myTeam) {
        this.myTeam = myTeam;
        this.lineUp = new LineUp();

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

            Role tRole;
            if (tRoleVal == 0) {
                tRole = Role.RIFLER;
            } else if (tRoleVal == 1) {
                tRole = Role.LURKER;
            } else {
                tRole = Role.AWPER;
            }

            Role ctRole;
            if (ctRoleVal == 0) {
                ctRole = Role.ANCHOR;
            } else if (ctRoleVal == 1) {
                ctRole = Role.ROTATOR;
            } else {
                ctRole = Role.AWPER;
            }
            lineUp.addPlayer(new LineUpPlayer(playerOptional.get(), ctRole, tRole));
            playerOptional.get().setBusy(true);
        }
    }

    public LineUp getLineUp() {
        return lineUp;
    }
}
