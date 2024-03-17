package com.csmanager.model.roles.roles;

import com.csmanager.model.match.Match;
import com.csmanager.model.player.Player;

public abstract class Role {
    private Player player;

    public Role(Player player) {
        this.player = player;
    }

    abstract double calculateSkill(Match match);

    abstract double calculateIncreaseSkill(Match match);

    boolean isRepeated() {

    }
    //sprawdza czy wybrana rola sie nie powtarza za czesto MAX 2 razy
}
