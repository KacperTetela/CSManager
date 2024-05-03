package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PlayerFactory {

    private String[] names = {"Neo", "PashaBiceps", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz", "isak", "Styko", "device", "Magisk", "Xyp9x"};
    private PlayerCreatingStrategy playerCreatingStrategy;



    private Player createPlayerByIter(int i) {
        PlayerBuilder playerBuilder = new PlayerBuilder();
        playerBuilder.name(names[i]);
        Player player = playerBuilder.build();
        return player;
    }

    private Player createPlayer(){
        return playerCreatingStrategy.createPlayer();
    }

    public List<Player> getPlayers(int numberOfPlayers) {
         Queue<Player> allPlayers = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            allPlayers.add(createPlayerByIter(i));
        }
        if (allPlayers.size() < numberOfPlayers) {
            throw new IllegalArgumentException("Not enough players");
        }
        List<Player> players = new LinkedList<>();
        IntStream.range(0, numberOfPlayers)
                .forEach(i -> players.add(allPlayers.poll()));
        return players;
    }

    List<Player> getStarterPlayers(){
        setStrategy("starter");
        return createPlayers(6);
    }

    List<Player> getToBuyPlayers(){
        setStrategy("semi");
        List<Player> players = new ArrayList<>();
        players.addAll(createPlayers(9));
        setStrategy("pro");
        players.addAll(createPlayers(1));
        return players;
    }

    private List<Player> createPlayers(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(createPlayer());
        }
        return players;
    }

    private void setStrategy(String playerSkill){
      playerCreatingStrategy =  switch (playerSkill) {
           case  "pro" -> new ProCreatingStrategy();
           case "semi" -> new SemiCreatingStrategy();
           case "starter" -> new AboveCreatingStrategy();
          default -> throw new RuntimeException("unidentified strategy");
        };
    }

    //createPlayer(Type)

}

/*
PlayerFactory:
List<Player> getPlayersToBuy() : zawsze 10 ->  Później mieszanka mid/pro
List<Player> getStarterPlayers() : 6 najsłabszych

Player createPlayer()




* startowi - słabi, nie są znani i nie płacimy za nich, mozemy ich expic, sa to standardowy playerzy
* semi - dokupywani - lepsi, coś kosztują, sa lekko lepsi od tych startowych w celu nadania dynamiki gry
* pro gracze - najlepski, bardzo drodzy, ręcznie wprowadzone staty -> json
* */