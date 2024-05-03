package com.csmanager.model.player.builder;

public class PlayerBuilderCustomDifficulty {
    private String name;
    private double difficulty;

    public PlayerBuilderCustomDifficulty name(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilderCustomDifficulty difficulty(double difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Player build() {
        return new Player(name, difficulty);
    }
}