package com.csmanager.model.lineup;

import com.csmanager.model.player.Player;

public class LineupPlayer {
    private Player player;
    private RoleType ctRoleType;
    private RoleType tRoleType;

    public LineupPlayer(Player player, RoleType ctRoleType, RoleType tRoleType) {
        this.player = player;
        this.ctRoleType = ctRoleType;
        this.tRoleType = tRoleType;
    }

    public double getTSkillLevel() {
        double skillLevel = 0;
        RoleType roleType = tRoleType;
        if (Chance.isRequired(roleType, player))
            skillLevel += Chance.calculate(roleType, player);
        skillLevel += player.getRolePoints().get(roleType);
        return skillLevel;
    }

    public double getCTSkillLevel() {
        double skillLevel = 0;
        RoleType roleType = ctRoleType;
        if (Chance.isRequired(roleType, player))
            skillLevel += Chance.calculate(roleType, player);
        skillLevel += player.getRolePoints().get(roleType);
        return skillLevel;
    }

    public void trainPlayer() {
        player.addPoints(tRoleType);
        player.addPoints(ctRoleType);
    }

    @Override
    public String toString() {
        return "LineUpPlayer{" +
                "player=" + player +
                ", ctRoleType=" + ctRoleType +
                ", tRoleType=" + tRoleType +
                '}';
    }

    public Player getPlayer() {
        return player;
    }
}
