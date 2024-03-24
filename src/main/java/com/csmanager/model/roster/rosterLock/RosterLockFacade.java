package com.csmanager.model.roster.rosterLock;

import com.csmanager.model.player.Player;
import com.csmanager.model.roles.roleType.RoleType;
import com.csmanager.model.roster.Roster;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

import java.util.Optional;
import java.util.Scanner;

public class RosterLockFacade {
    private final Team myTeam;
    private Roster roster;
    RosterPlayersService rosterPlayersService;
    RosterRolesService rosterRolesService;

    public RosterLockFacade(Team myTeam) {
        this.myTeam = myTeam;
        this.roster = new Roster();
        rosterPlayersService = new RosterPlayersService();
        rosterRolesService = new RosterRolesService();
    }

    public void createRoster() {
        rosterPlayersService.select(myTeam, roster);
        rosterRolesService.select(myTeam, roster);
    }

    public Roster getRoster() {
        return roster;
    }
}

/*
 * Match + playera + role
 *  = strategia
 *
 *
 * */
