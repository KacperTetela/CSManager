package com.csmanager.model.shop.market;

import com.csmanager.model.player.player.Player;
import com.csmanager.model.player.player.creatingStrategy.CreatingStrategyService;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BuyPlayer {
    private final List<Player> availablePlayers = new ArrayList<>();
    private int selectedPlayerNumber;
    private final int selectedPlayerPrice = 500;
    private final Team team;

    public BuyPlayer(Team team) {
        this.team = team;
        generatePlayers();
    }

    public void launch() {
        displayAvailablePlayers();
        moveToTeam();
        payForPlayer();
    }

    private void generatePlayers() {
        CreatingStrategyService creatingStrategyService = new CreatingStrategyService();
        availablePlayers.addAll(creatingStrategyService.getToBuyPlayers());
    }

    private void displayAvailablePlayers() {
        for (int i = 1; i < (availablePlayers.size() + 1); i++) {
            System.out.println("\n" + i + ". " + availablePlayers.get(i - 1) + "\n");
        }
        selectedPlayerNumber = Utils.askAboutInt("Which player do you pick up?\n" +
                "select 0 to cancel");
    }

    private void moveToTeam() {
        int index = selectedPlayerNumber;
        team.addPlayer(availablePlayers.get(index - 1));
        availablePlayers.remove(index - 1);
    }

    private void payForPlayer() {
        if (team.getMoney() >= selectedPlayerPrice) {
            team.removeMoney(500);
        } else {
            System.out.println("You do not have enough money!");
        }
    }
}
