package com.csmanager.model.player.builder;

public class PlayerBuilderKox extends PlayerBuilder{
    @Override
    public PlayerBuilder playerStatsScope() {
        this.playerStatsScope = PlayerStatsScope.KOX;
        return this;
    }
}
