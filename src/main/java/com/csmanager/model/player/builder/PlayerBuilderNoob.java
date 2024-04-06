package com.csmanager.model.player.builder;

public class PlayerBuilderNoob extends PlayerBuilder{
    @Override
    public PlayerBuilder playerStatsScope() {
        this.playerStatsScope = PlayerStatsScope.NOOB;
        return this;
    }
}