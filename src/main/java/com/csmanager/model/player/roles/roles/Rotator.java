package com.csmanager.model.player.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.roles.roleType.RoleType;

public class Rotator extends Role {
    public Rotator(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return player.getRolePoints().get(RoleType.ROTATOR);
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
