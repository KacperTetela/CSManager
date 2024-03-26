package com.csmanager.model.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.Player;
import com.csmanager.model.roles.roleType.RoleType;

public class Rotator extends Role {
    public Rotator(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return 1;
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
