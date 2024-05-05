package com.csmanager.model.player.player.creatingStrategy;

import com.csmanager.model.player.player.Player;

import java.util.ArrayList;
import java.util.List;

public class CreatingStrategyService {
    private PlayerCreatingStrategy playerCreatingStrategy;

    private void setStrategy(String creatingStrategy) {
        playerCreatingStrategy = switch (creatingStrategy) {
            case "pro" -> new ProCreatingStrategy();
            case "above" -> new AboveCreatingStrategy();
            case "default" -> new DefaultCreatingStrategy();
            default -> throw new RuntimeException("unidentified strategy");
        };
    }

    public Player createPlayer(String strategy) {
        setStrategy(strategy);
        return playerCreatingStrategy.createPlayer();
    }

    public List<Player> createPlayers(int count, String strategy) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(createPlayer(strategy));
        }
        return players;
    }

    public List<Player> getStarterPlayers() {
        return createPlayers(6, "default");
    }

    public List<Player> getToBuyPlayers() {
        List<Player> players = new ArrayList<>();
        players.addAll(createPlayers(5, "above"));
        players.addAll(createPlayers(1, "pro"));
        return players;
    }
}

/*
CreatingStrategyService:
List<Player> getPlayersToBuy() : zawsze 10 ->  Później mieszanka mid/pro
List<Player> getStarterPlayers() : 6 najsłabszych

Player createPlayer()




* startowi - słabi, nie są znani i nie płacimy za nich, mozemy ich expic, sa to standardowy playerzy
* semi - dokupywani - lepsi, coś kosztują, sa lekko lepsi od tych startowych w celu nadania dynamiki gry
* pro gracze - najlepski, bardzo drodzy, ręcznie wprowadzone staty -> json
* */