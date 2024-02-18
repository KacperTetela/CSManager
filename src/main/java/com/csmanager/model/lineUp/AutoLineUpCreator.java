package com.csmanager.model.lineUp;

import com.csmanager.model.Player;
import com.csmanager.model.PlayerStatsScope;
import com.github.javafaker.Faker;

public class AutoLineUpCreator {
    private LineUp lineUp;

    public AutoLineUpCreator() {
        Faker faker = new Faker();
        this.lineUp = new LineUp();
        Role[] rolesCT = {Role.ANCHOR, Role.ANCHOR, Role.ROTATOR, Role.ROTATOR, Role.AWPER};
        Role[] rolesT = {Role.LURKER, Role.LURKER, Role.RIFLER, Role.RIFLER, Role.AWPER};
        for (int i = 0; i < 5; i++) {
            lineUp.addPlayer(new LineUpPlayer(new Player(faker.name().name(), PlayerStatsScope.NOOB), rolesCT[i], rolesT[i]));
        }
    }

    public LineUp getLineUp() {
        return lineUp;
    }
}
