package com.csmanager.model.player.builder;

public enum PlayerStatsScope {
    PRO(0.2,0.25),
    KOX(0.1,0.2),
    NOOB(0.05,0.1);

    private double minRange;
    private double maxRange;

    PlayerStatsScope(double minRange, double maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public double rollPotential() {
        double potentialVal;
        if (this == PlayerStatsScope.PRO) {
            potentialVal = 0.2 + Math.random()/20;
        } else if (this == PlayerStatsScope.KOX) {
            potentialVal = 0.1 + Math.random()/10;
        } else {
            potentialVal = 0.05 + Math.random()/20;
        }
        return potentialVal;
    }

    public double rollStats() {
        return Math.random()/4 + 0.2; // 0,2 - 0,45
    }
}

//return (maxRange - minRange) *Math.random() + minRange;