package com.csmanager.model.player.builder;

public enum PlayerRolePointsScope {
    HIGH(0.2,0.25),
    LOW(0.05,0.1);

    private double minRange;
    private double maxRange;
    private double potentialPoints;
    private double statsPoints;

    PlayerRolePointsScope(double minRange, double maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    /**
     * musze zrobic tak zeby potential byl polaczony z stats
     * duzy stats u lurkera = duzy potential u lurkera
     *
     * ktos moze byc pro jakos lurk, a jako awp noob
     * @return
     */

    private void rollPoints() {
        potentialPoints = rollPotential();
        statsPoints = rollStats();
    }

    public double rollPotential() {
        double potentialVal;
        switch (this) {
            case HIGH -> potentialVal = 0.2 + Math.random()/20;
            case LOW -> potentialVal = 0.05 + Math.random()/20;
            default -> potentialVal = 0;
        }
        return potentialVal;
    }

    public double rollStats() {
        return Math.random()/4 + 0.2; // 0,2 - 0,45
    }
}

//return (maxRange - minRange) *Math.random() + minRange;