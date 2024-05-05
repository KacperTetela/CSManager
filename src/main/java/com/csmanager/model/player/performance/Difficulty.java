package com.csmanager.model.player.performance;

public class Difficulty {
    private static final Difficulty DIFFICULTY = new Difficulty();
    private double difficultyPoints = 1.0;
    private final double maxDifficultyPoints = 2.0;

    private Difficulty() {
    }

    public static Difficulty getInstance() {
        return DIFFICULTY;
    }

    public double getValue() {
        return difficultyPoints;
    }

    public void increase() {
        if (difficultyPoints < maxDifficultyPoints) {
            difficultyPoints += 0.05;
            System.out.println("DifficultyPoints are now " + difficultyPoints);
        }
    }

    public void reduce() {
        if (difficultyPoints > (maxDifficultyPoints - 1)) {
            difficultyPoints -= 0.05;
            System.out.println("DifficultyPoints are now " + difficultyPoints);
        }
    }
}

