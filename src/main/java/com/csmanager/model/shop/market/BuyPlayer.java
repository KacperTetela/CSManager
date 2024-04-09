package com.csmanager.model.shop.market;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class BuyPlayer {
    private final List<Player> availablePlayers = new ArrayList<>();

    public BuyPlayer() {
        PlayerBuilder playerBuilder = new PlayerBuilder();
        Faker faker = new Faker();
    }

    public void launch(PlayerBuilder playerBuilder, Faker faker) {
        generatePlayers(playerBuilder, faker);
    }

    private void generatePlayers(PlayerBuilder playerBuilder, Faker faker) {
        for (int i = 0; i < 3; i++) {
            Player player = createPlayer(playerBuilder, faker);
            availablePlayers.add(player);
        }
    }

    private Player createPlayer(PlayerBuilder playerBuilder, Faker faker) {
        playerBuilder.name(faker.name().name());
        Player player = playerBuilder.build();
        return player;
    }
}
