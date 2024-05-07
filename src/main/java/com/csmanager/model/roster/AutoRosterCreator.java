package com.csmanager.model.roster;

import com.csmanager.model.player.player.Player;
import com.csmanager.model.player.player.creatingStrategy.CreatingStrategyService;
import com.csmanager.model.player.roles.roleType.RoleType;
import com.github.javafaker.Faker;

public class AutoRosterCreator {
    private final Roster roster;

    public AutoRosterCreator(CreatingStrategyService creatingStrategyService) {
        Faker faker = new Faker();
        this.roster = new Roster();
        RoleType[] rolesCT = {RoleType.ANCHOR, RoleType.ANCHOR, RoleType.ROTATOR, RoleType.ROTATOR, RoleType.AWPER};
        RoleType[] rolesT = {RoleType.LURKER, RoleType.LURKER, RoleType.RIFLER, RoleType.RIFLER, RoleType.AWPER};
        for (int i = 0; i < 5; i++) {
            Player player;
            if (i <= 3) {
                player = creatingStrategyService.createPlayer("default");
            } else {
                player = creatingStrategyService.createPlayer("above");
            }
            player.setRoles(rolesCT[i], rolesT[i]);
            player.setBusy(true);
            roster.addPlayer(player);
        }
    }

    public Roster getRoster() {
        return roster;
    }
}