package com.csmanager.model.player.player.creatingStrategy;

import com.csmanager.model.player.player.Player;
import com.csmanager.model.player.player.PlayerBuilder;
import com.csmanager.model.player.performance.Difficulty;
import com.github.javafaker.Faker;

public class DefaultCreatingStrategy implements PlayerCreatingStrategy {
    private final Faker faker = new Faker();

    @Override
    public Player createPlayer() {
        PlayerBuilder playerBuilder = new PlayerBuilder().name(faker.name().name())
                .difficulty(Difficulty.getInstance().getValue());
        return playerBuilder.build();
    }
}