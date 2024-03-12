package com.csmanager.model.lineup;

import java.util.Arrays;
import java.util.List;

public enum RoleType {
    ANCHOR(Side.CT, false),
    AWPER(Side.BOTH, true),
    ROTATOR(Side.CT, false),
    RIFLER(Side.T, true),
    LURKER(Side.T, true);

    private Side side;
    private boolean isPotentialRequired;

    RoleType(Side side, boolean isPotentialRequired) {
        this.side = side;
        this.isPotentialRequired = isPotentialRequired;
    }

    public Side getSide() {
        return side;
    }


    public static List<RoleType> getPotentialRoles() {
        return Arrays.stream(values())
                        .filter(role -> role.isPotentialRequired)
                                .toList();
    }


}
