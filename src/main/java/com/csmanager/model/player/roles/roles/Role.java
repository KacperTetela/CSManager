package com.csmanager.model.player.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.builder.Player;

public abstract class Role {
    protected Player player;

    public Role(Player player) {
        this.player = player;
    }

    abstract double calculateSkill(Match match);

    abstract double calculateIncreaseSkill(Match match);
}
