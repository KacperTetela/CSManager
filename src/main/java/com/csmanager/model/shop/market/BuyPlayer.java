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
    private final Team team;

    public BuyPlayer(Team team) {
        this.team = team;
        generatePlayers();
    }

    public void launch() {
        displayAvailablePlayers();
        /**
         * If Manager has enough money to buy new player boolean will return true, else false
         */
        if (payForPlayer()) {
            moveToTeam();
        }
    }

    private void generatePlayers() {
        CreatingStrategyService creatingStrategyService = new CreatingStrategyService();
        availablePlayers.addAll(creatingStrategyService.getToBuyPlayers());
    }

    private void displayAvailablePlayers() {
        for (int i = 1; i < (availablePlayers.size() + 1); i++) {
            System.out.println("\n" + i + ". " + availablePlayers.get(i - 1).getView(team.getStatsVisibilityLevel()) + "\n");
        }
        selectedPlayerNumber = Utils.askAboutInt("Which player do you pick up?\n" +
                "select 0 to cancel");
    }

    private void moveToTeam() {
        team.addPlayer(availablePlayers.get(selectedPlayerNumber - 1));
        availablePlayers.remove(selectedPlayerNumber - 1);
    }

    private boolean payForPlayer() {
        int getMarketValue = availablePlayers.get(selectedPlayerNumber - 1).getMarketValue();
        if (team.getMoney() >= getMarketValue) {
            team.removeMoney(getMarketValue);
            return true;
        } else {
            System.out.println("You do not have enough money!");
            return false;
        }
    }
}
