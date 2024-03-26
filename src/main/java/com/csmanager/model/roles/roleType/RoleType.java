package com.csmanager.model.roles.roleType;

import java.util.Arrays;
import java.util.List;

public enum RoleType {
    ANCHOR(Side.CT, false),
    AWPER(Side.BOTH, true,1),
    ROTATOR(Side.CT, false),
    RIFLER(Side.T, true),
    LURKER(Side.T, true);

    private Side side;
    private boolean isPotentialRequired;
    private int maxPerRoosterSide;

    RoleType(Side side, boolean isPotentialRequired) {
        this.side = side;
        this.isPotentialRequired = isPotentialRequired;
        maxPerRoosterSide = 2;
    }

    RoleType(Side side, boolean isPotentialRequired, int maxPerRoosterSide) {
        this.side = side;
        this.isPotentialRequired = isPotentialRequired;
        this.maxPerRoosterSide = maxPerRoosterSide;
    }

    public Side getSide() {
        return side;
    }

    public int getMaxPerRoosterSide() {
        return maxPerRoosterSide;
    }

    public static List<RoleType> getPotentialRoles() {
        return Arrays.stream(values())
                        .filter(role -> role.isPotentialRequired)
                                .toList();
    }

    public static List<RoleType> getRolesBy(Side side) {
        return Arrays.stream(RoleType.values())
                .filter(type -> type.getSide() == side || type.getSide() == Side.BOTH)
                .toList();
    }


}
