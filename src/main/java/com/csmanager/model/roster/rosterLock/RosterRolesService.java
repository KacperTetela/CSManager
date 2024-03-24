package com.csmanager.model.roster.rosterLock;

import com.csmanager.model.player.Player;
import com.csmanager.model.roles.roleType.RoleType;
import com.csmanager.model.roster.Roster;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

public class RosterRolesService {
    public RosterRolesService() {
    }

    public void select(Team myTeam, Roster roster) {
        for (Player player : roster.getPlayers()) {
            int tRoleVal = Utils.askAboutInt("Select roles T for " + player.getName() + "\n rifler=0 lurker=1 awp=2");
            int ctRoleVal = Utils.askAboutInt("Select roles CT for " + player.getName() + "\n anchor=0 rotator=1 awp=2");

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
        }
    }
}
