package com.csmanager.model.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.builder.Player;
import com.csmanager.model.roles.roleType.RoleType;

public class Lurker extends Role{
    public Lurker(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return player.getRolePoints().get(RoleType.LURKER);
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
