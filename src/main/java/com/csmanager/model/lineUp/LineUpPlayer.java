package com.csmanager.model.lineUp;

import com.csmanager.model.Player;

public class LineUpPlayer {
    private Player player;
    private Role ctRole;
    private Role tRole;

    public LineUpPlayer(Player player, Role ctRole, Role tRole) {
        this.player = player;
        this.ctRole = ctRole;
        this.tRole = tRole;
    }

    public double getSkillLevel() {
        return player.getSkillLevel();
    }

    @Override
    public String toString() {
        return "LineUpPlayer{" +
                "player=" + player +
                ", ctRole=" + ctRole +
                ", tRole=" + tRole +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public void trainPlayer() {
        player.addPoints(tRole);
        player.addPoints(ctRole);
    }
}
