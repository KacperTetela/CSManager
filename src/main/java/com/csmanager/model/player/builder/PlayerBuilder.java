package com.csmanager.model.player.builder;

public abstract class PlayerBuilder {
    protected String name;
    protected PlayerStatsScope playerStatsScope;

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder playerStatsScope() {
        return this;
    }

    public Player build() {
        return new Player(name, playerStatsScope);
    }
}
