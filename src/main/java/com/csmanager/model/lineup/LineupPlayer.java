package com.csmanager.model.lineup;

import com.csmanager.model.player.Player;

public class LineupPlayer {
    private Player player;
    private Role ctRole;
    private Role tRole;

    public LineupPlayer(Player player, Role ctRole, Role tRole) {
        this.player = player;
        this.ctRole = ctRole;
        this.tRole = tRole;
    }

    public double getSkillLevel() {
        double skillLevel = 0;
        Role[] rolesForEachPlayer = {tRole, ctRole};
        for (Role role : rolesForEachPlayer) {
            if (Chance.isRequired(role, player)) {
                skillLevel += Chance.calculate(role, player);
            }
            //todo tu pojawia sie Null
            //skillLevel += player.getRolePoints().get(role);
            //moze chodzic o to ze na poczatku inicjuemy get(object Role), a pozniej przypisujemy role
        }
        return skillLevel;
    }

    public void trainPlayer() {
        player.addPoints(tRole);
        player.addPoints(ctRole);
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
