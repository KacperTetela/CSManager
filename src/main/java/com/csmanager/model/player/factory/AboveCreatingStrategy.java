package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.csmanager.model.player.builder.PlayerBuilderCustomDifficulty;
import com.csmanager.model.player.performance.Difficulty;
import com.github.javafaker.Faker;

public class AboveCreatingStrategy implements PlayerCreatingStrategy {
    private final Faker faker = new Faker();

    @Override
    public Player createPlayer() {
        return createRandomPlayer();
    }

    private Player createRandomPlayer() {
        PlayerBuilderCustomDifficulty builder = new PlayerBuilderCustomDifficulty().name(faker.name().name())
                .difficulty((Difficulty.getInstance().getValue()) + 0.2);
        return builder.build();
    }
}
