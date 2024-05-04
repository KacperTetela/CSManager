package com.csmanager.model.player.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.player.Player;
import com.csmanager.model.player.roles.roleType.RoleType;

public class Lurker extends Role{
    public Lurker(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return player.getRolePoints(RoleType.LURKER);
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
