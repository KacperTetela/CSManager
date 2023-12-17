package com.csmanager.carrer.startingLineUp.CTSideRoles;

public class CTSideRoles {
    CTSideRole aAnchor = CTSideRole.ANCHOR;
    CTSideRole bAnchor = CTSideRole.ANCHOR;
    CTSideRole awper = CTSideRole.AWPER;
    CTSideRole rotator1 = CTSideRole.ROTATOR;
    CTSideRole rotator2 = CTSideRole.ROTATOR;
    CTSideRole inGameLeader = CTSideRole.LEADER;

    public CTSideRoles(CTSideRole aAnchor, CTSideRole bAnchor, CTSideRole awper, CTSideRole rotator1, CTSideRole rotator2, CTSideRole inGameLeader) {
        this.aAnchor = aAnchor;
        this.bAnchor = bAnchor;
        this.awper = awper;
        this.rotator1 = rotator1;
        this.rotator2 = rotator2;
        this.inGameLeader = inGameLeader;
    }
}
