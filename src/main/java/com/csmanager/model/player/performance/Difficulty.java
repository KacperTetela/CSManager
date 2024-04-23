package com.csmanager.model.player.performance;

public class Difficulty {
    private static final Difficulty DIFFICULTY = new Difficulty();
    private double difficultyPoints = 1.0;

    private Difficulty() {
    }

    public static Difficulty getInstance() {
        return DIFFICULTY;
    }

    public double getValue() {
        return difficultyPoints;
    }

    public void increase() {
        difficultyPoints += 0.05;
    }
}

