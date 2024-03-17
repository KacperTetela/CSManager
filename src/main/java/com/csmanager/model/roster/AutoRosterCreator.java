package com.csmanager.model.roster;

import com.csmanager.model.player.Player;
import com.csmanager.model.player.PlayerStatsScope;
import com.csmanager.model.roles.roleType.RoleType;
import com.github.javafaker.Faker;

public class AutoRosterCreator {
    private Roster lineUp;

    public AutoRosterCreator() {
        Faker faker = new Faker();
        this.lineUp = new Roster();
        RoleType[] rolesCT = {RoleType.ANCHOR, RoleType.ANCHOR, RoleType.ROTATOR, RoleType.ROTATOR, RoleType.AWPER};
        RoleType[] rolesT = {RoleType.LURKER, RoleType.LURKER, RoleType.RIFLER, RoleType.RIFLER, RoleType.AWPER};
        for (int i = 0; i < 5; i++) {
            Player player = new Player(faker.name().name(), PlayerStatsScope.NOOB);
            player.setRoles(rolesCT[i], rolesT[i]);
            player.setBusy(true);
            lineUp.addPlayer(player);
        }
    }

    public Roster getLineUp() {
        return lineUp;
    }
}