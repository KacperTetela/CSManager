package com.csmanager.model.roster.rosterLock;

import com.csmanager.model.roster.Roster;
import com.csmanager.model.team.Team;

public class RosterLockFacade {
    private final Team myTeam;
    private final Roster roster;
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
