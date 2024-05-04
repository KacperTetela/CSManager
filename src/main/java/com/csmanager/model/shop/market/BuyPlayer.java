package com.csmanager.model.shop.market;

import com.csmanager.model.player.player.Player;
import com.csmanager.model.player.player.PlayerBuilder;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class BuyPlayer {
    private final List<Player> availablePlayers = new ArrayList<>();
    private int selectedPlayerNumber;
    private Team team;

    public BuyPlayer(Team team) {
        PlayerBuilder playerBuilder = new PlayerBuilder();
        Faker faker = new Faker();
        this.team = team;
    }

    public void launch(PlayerBuilder playerBuilder, Faker faker) {
        generatePlayers(playerBuilder, faker);
        displayAvailablePlayers();
        moveToTeam();
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

    private void displayAvailablePlayers() {
        for (int i = 0; i < availablePlayers.size(); i++) {
            System.out.println(i + 1 + ". " + availablePlayers.get(i));
        }
        selectedPlayerNumber = Utils.askAboutInt("Which player do you pick up?\n" +
                "select 0 to cancel");
    }

    private void moveToTeam() {
        int index = selectedPlayerNumber;
        team.addPlayer(availablePlayers.get(index));
    }
}
