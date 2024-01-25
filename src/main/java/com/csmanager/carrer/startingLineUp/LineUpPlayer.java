package com.csmanager.carrer.startingLineUp;

import com.csmanager.carrer.startingLineUp.Role;
import com.csmanager.Player;

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
}
