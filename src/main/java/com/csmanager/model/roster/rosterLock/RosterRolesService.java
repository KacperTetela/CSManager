package com.csmanager.model.roster.rosterLock;

import com.csmanager.model.player.Player;
import com.csmanager.model.roles.roleType.RoleType;
import com.csmanager.model.roster.Roster;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

import java.util.List;

public class RosterRolesService {
    public void select( Roster roster) {
        byte[][] isSetted = new byte[2][3];
        /**
         * byte isSetted [][] - first[] = CT or T, second[] = RoleType
         */
        List<Player> players = roster.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            int tRoleVal = Utils.askAboutInt("Select roles T for " + player.getName() + "\n " +
                    "rifler=1 lurker=2 awp=3");
            if (isSetted[0][tRoleVal - 1] >= 2) {
                i--;
                System.out.println("Selected Role is played");
                continue;
            }
            isSetted[0][tRoleVal - 1]++;


            int ctRoleVal = Utils.askAboutInt("Select roles CT for " + player.getName() + "\n anchor=1 rotator=2 awp=3");

            switch (ctRoleVal) {
                case 1 -> isSetted[1][0] += 1;
                case 2 -> isSetted[1][1] += 1;
                case 3 -> isSetted[1][2] += 1;
            }

            RoleType tRoleType;
            if (tRoleVal == 1) {
                tRoleType = RoleType.RIFLER;
            } else if (tRoleVal == 2) {
                tRoleType = RoleType.LURKER;
            } else {
                tRoleType = RoleType.AWPER;
            }

            RoleType ctRoleType;
            if (ctRoleVal == 1) {
                ctRoleType = RoleType.ANCHOR;
            } else if (ctRoleVal == 2) {
                ctRoleType = RoleType.ROTATOR;
            } else {
                ctRoleType = RoleType.AWPER;
            }
            player.setRoles(ctRoleType, tRoleType);
        }
    }
}
