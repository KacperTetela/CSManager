package com.csmanager.model.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.Player;

public class Lurker extends Role{
    public Lurker(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return 4;
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
