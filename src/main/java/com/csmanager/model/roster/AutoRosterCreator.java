package com.csmanager.model.roster;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.csmanager.model.player.builder.PlayerBuilderPro;
import com.csmanager.model.player.builder.PlayerStatsScope;
import com.csmanager.model.roles.roleType.RoleType;
import com.github.javafaker.Faker;

public class AutoRosterCreator {
    private Roster roster;

    public AutoRosterCreator() {
        Faker faker = new Faker();
        this.roster = new Roster();
        RoleType[] rolesCT = {RoleType.ANCHOR, RoleType.ANCHOR, RoleType.ROTATOR, RoleType.ROTATOR, RoleType.AWPER};
        RoleType[] rolesT = {RoleType.LURKER, RoleType.LURKER, RoleType.RIFLER, RoleType.RIFLER, RoleType.AWPER};
        for (int i = 0; i < 5; i++) {
            PlayerBuilder playerBuilder = new PlayerBuilderPro().name(faker.name().name()).playerStatsScope();
            Player player = playerBuilder.build();
            player.setRoles(rolesCT[i], rolesT[i]);
            player.setBusy(true);
            roster.addPlayer(player);
        }
    }

    public Roster getRoster() {
        return roster;
    }
}
