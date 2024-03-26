package com.csmanager.model.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.Player;
import com.csmanager.model.roles.roleType.RoleType;

public class Awper extends Role {
    public Awper(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return player.getRolePoints().get(RoleType.AWPER);
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
