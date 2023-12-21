package com.csmanager.playermodel;

import com.csmanager.carrer.startingLineUp.Role;

public class LineUpPlayer {
    private Player player;
    private Role ctRole;
    private Role tRole;

    public LineUpPlayer(Player player, Role ctRole, Role tRole) {
        this.player = player;
        this.ctRole = ctRole;
        this.tRole = tRole;
    }
}
