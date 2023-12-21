package com.csmanager.carrer.startingLineUp;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ANCHOR(Side.CT, false),
    AWPER(Side.BOTH, true),
    ROTATOR(Side.CT, false),
    LEADER(Side.BOTH, true),
    RIFLER(Side.T, true),
    LURKER(Side.T, true);

    private Side side;
    private boolean isPotentialRequired;

    Role(Side side, boolean isPotentialRequired) {
        this.side = side;
        this.isPotentialRequired = isPotentialRequired;
    }

    public Side getSide() {
        return side;
    }


    public static List<Role> getPotentialRoles() {
        return Arrays.stream(values())
                        .filter(role -> role.isPotentialRequired)
                                .toList();
    }


}
