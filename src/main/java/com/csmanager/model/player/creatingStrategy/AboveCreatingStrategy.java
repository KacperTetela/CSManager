package com.csmanager.model.player.creatingStrategy;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.csmanager.model.player.performance.Difficulty;
import com.github.javafaker.Faker;

public class AboveCreatingStrategy implements PlayerCreatingStrategy {
    private final Faker faker = new Faker();

    @Override
    public Player createPlayer() {
        PlayerBuilder playerBuilder = new PlayerBuilder().name(faker.name().name())
                .difficulty((Difficulty.getInstance().getValue()) + 0.2);
        return playerBuilder.build();
    }
}