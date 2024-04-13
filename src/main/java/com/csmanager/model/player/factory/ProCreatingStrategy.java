package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;
import com.csmanager.model.player.builder.PlayerBuilder;

public class ProCreatingStrategy implements PlayerCreatingStrategy{
    private String[] names = {"Neo", "PashaBiceps", "Snax", "dupreeh", "TaZ", "byali", "Gla1ve", "Zywoo", "Keoz",
            "isak", "Styko", "device", "Magisk", "Xyp9x"};

    @Override
    public Player createPlayer() {
        return null;
    }

    private Player createPlayerByIter(int i) {
        PlayerBuilder playerBuilder = new PlayerBuilder();
        playerBuilder.name(names[i]);
        Player player = playerBuilder.build();
        return player;
    }

}
