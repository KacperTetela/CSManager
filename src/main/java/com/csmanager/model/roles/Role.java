package com.csmanager.model.roles;

import com.csmanager.model.Match;
import com.csmanager.model.player.Player;

public abstract class Role {
    private Player player;

    public Role(Player player) {
        this.player = player;
    }

    abstract double calculateSkill(Match match);

    abstract double calculateIncreaseSkill(Match match);
}
