package com.csmanager.model.player.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.roles.roleType.RoleType;

public class Anchor extends Role{
    public Anchor(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return player.getRolePoints(RoleType.ANCHOR);
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
    //Match.java
    //ChanceService.java
    //Player.java (potential)
    //

}
