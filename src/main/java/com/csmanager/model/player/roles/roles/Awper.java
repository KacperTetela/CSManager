package com.csmanager.model.player.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.roles.roleType.RoleType;

public class Awper extends Role {
    public Awper(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return player.getRolePoints(RoleType.AWPER);
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
