package com.csmanager.model.roles;

import com.csmanager.model.Match;
import com.csmanager.model.player.Player;

public class Awper extends Role {
    public Awper(Player player) {
        super(player);
    }

    @Override
    double calculateSkill(Match match) {
        return 0;
    }

    @Override
    double calculateIncreaseSkill(Match match) {
        return 0;
    }
}
