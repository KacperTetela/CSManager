package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.github.javafaker.Faker;

public class SemiCreatingStrategy implements PlayerCreatingStrategy{
    private final Faker faker = new Faker();

    @Override
    public Player createPlayer() {
        return null;
    }

    private Player createRandomPlayer() {
        //Dodac buildera ktory uwzgledni parametr trudnosci, dificulty
        PlayerBuilder playerBuilder = new PlayerBuilder().name(faker.name().name());
        return playerBuilder.build();
    }
}
