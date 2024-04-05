package com.csmanager.model.player.builder;

public class PlayerBuilder {
    private String name;
    private PlayerStatsScope playerStatsScope;

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder playerStatsScope(PlayerStatsScope playerStatsScope) {
        this.playerStatsScope = playerStatsScope;
        return this;
    }

    public Player build() {
        return new Player(name, playerStatsScope);
    }
}
