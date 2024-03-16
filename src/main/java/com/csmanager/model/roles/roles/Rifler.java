package com.csmanager.model.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.Player;

public class Rifler extends Role {
    public Rifler(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return 1.1;
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
