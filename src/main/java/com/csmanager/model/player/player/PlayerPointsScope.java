package com.csmanager.model.player.player;

public enum PlayerPointsScope {
    HIGH(0.2, 0.25),
    LOW(0.1, 0.15);

    private double minPotentialRange;
    private double maxPotentialRange;
    private double potentialPoints;
    private double statsPoints;

    PlayerPointsScope(double minPotentialRange, double maxPotentialRange) {
        this.minPotentialRange = minPotentialRange;
        this.maxPotentialRange = maxPotentialRange;
    }

    public double rollPotential() {
        double potentialVal;
        switch (this) {
            case HIGH -> potentialVal = 0.2 + Math.random() / 20;
            case LOW -> potentialVal = 0.1 + Math.random() / 20;
            default -> potentialVal = 0;
        }
        return potentialVal;
    }

    public double rollStats(double DificultyLevel) {
        return Math.random() / 4 + 0.2; // 0,2 - 0,45
    }
}

//return (maxRange - minRange) *Math.random() + minRange;