package com.csmanager.model.player.builder;

public class PlayerBuilderPro extends PlayerBuilder{
    @Override
    public PlayerBuilder playerStatsScope() {
        this.playerStatsScope = PlayerStatsScope.PRO;
        return this;
    }
}
