package com.csmanager.model.lineup;

import com.csmanager.model.player.Player;
import com.csmanager.model.player.PlayerStatsScope;
import com.github.javafaker.Faker;

public class AutoLineupCreator {
    private Lineup lineUp;

    public AutoLineupCreator() {
        Faker faker = new Faker();
        this.lineUp = new Lineup();
        RoleType[] rolesCT = {RoleType.ANCHOR, RoleType.ANCHOR, RoleType.ROTATOR, RoleType.ROTATOR, RoleType.AWPER};
        RoleType[] rolesT = {RoleType.LURKER, RoleType.LURKER, RoleType.RIFLER, RoleType.RIFLER, RoleType.AWPER};
        for (int i = 0; i < 5; i++) {
            Player player = new Player(faker.name().name(), PlayerStatsScope.NOOB);
            player.setRoles(rolesCT[i], rolesT[i]);
            player.setBusy(true);
            lineUp.addPlayer(player);
        }
    }

    public Lineup getLineUp() {
        return lineUp;
    }
}
