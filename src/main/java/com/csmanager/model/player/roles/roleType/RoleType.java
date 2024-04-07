package com.csmanager.model.player.roles.roleType;

import java.util.Arrays;
import java.util.List;

public enum RoleType {
    ANCHOR(Side.CT),
    AWPER(Side.BOTH, 1),
    ROTATOR(Side.CT),
    RIFLER(Side.T),
    LURKER(Side.T);
    private Side side;
    private final int maxPerRoosterSide;

    RoleType(Side side) {
        this.side = side;
        maxPerRoosterSide = 2;
    }

    RoleType(Side side, int maxPerRoosterSide) {
        this.side = side;
        this.maxPerRoosterSide = maxPerRoosterSide;
    }

    public Side getSide() {
        return side;
    }

    public int getMaxPerRoosterSide() {
        return maxPerRoosterSide;
    }

    public static List<RoleType> getRoles() {
        return Arrays.stream(values())
                .toList();
    }

    public static List<RoleType> getRolesBy(Side side) {
        return Arrays.stream(RoleType.values())
                .filter(type -> type.getSide() == side || type.getSide() == Side.BOTH)
                .toList();
    }
}