package com.csmanager.carrer.startingLineUp.TSideRoles;

public class TSideRoles {
    TSideRole aLurker = TSideRole.LURKER;
    TSideRole bLurker = TSideRole.LURKER;
    TSideRole rifler1 = TSideRole.RIFLER;
    TSideRole rifler2 = TSideRole.RIFLER;
    TSideRole awper = TSideRole.AWPER;
    TSideRole inGameLeader = TSideRole.LEADER;

    public TSideRoles(TSideRole aLurker, TSideRole bLurker, TSideRole rifler1, TSideRole rifler2, TSideRole awper, TSideRole inGameLeader) {
        this.aLurker = aLurker;
        this.bLurker = bLurker;
        this.rifler1 = rifler1;
        this.rifler2 = rifler2;
        this.awper = awper;
        this.inGameLeader = inGameLeader;
    }
}
