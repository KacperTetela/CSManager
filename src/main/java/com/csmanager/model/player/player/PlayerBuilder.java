package com.csmanager.model.player.player;

public class PlayerBuilder {
    private String name;
    private double difficulty;

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder difficulty(double difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Player build() {
        return new Player(name, difficulty);
    }
}