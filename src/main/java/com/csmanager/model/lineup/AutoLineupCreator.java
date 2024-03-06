package com.csmanager.model.lineup;

import com.csmanager.model.player.Player;
import com.csmanager.model.player.PlayerStatsScope;
import com.github.javafaker.Faker;

public class AutoLineupCreator {
    private Lineup lineUp;

    public AutoLineupCreator() {
        Faker faker = new Faker();
        this.lineUp = new Lineup();
        Role[] rolesCT = {Role.ANCHOR, Role.ANCHOR, Role.ROTATOR, Role.ROTATOR, Role.AWPER};
        Role[] rolesT = {Role.LURKER, Role.LURKER, Role.RIFLER, Role.RIFLER, Role.AWPER};
        for (int i = 0; i < 5; i++) {
            lineUp.addPlayer(new LineupPlayer(new Player(faker.name().name(), PlayerStatsScope.NOOB), rolesCT[i], rolesT[i]));
        }
    }

    public Lineup getLineUp() {
        return lineUp;
    }
}
