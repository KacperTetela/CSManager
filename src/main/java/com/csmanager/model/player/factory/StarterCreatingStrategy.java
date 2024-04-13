package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.github.javafaker.Faker;

public class StarterCreatingStrategy implements PlayerCreatingStrategy{
    private final Faker faker = new Faker();

    @Override
    public Player createPlayer() {
        return createRandomPlayer();
    }

    private Player createRandomPlayer() {
        PlayerBuilder playerBuilder = new PlayerBuilder().name(faker.name().name());
        return playerBuilder.build();
    }
}
