package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;
import com.github.javafaker.Faker;

public class StarterCreatingStrategy implements PlayerCreatingStrategy{
    private String[] names;
    public StarterCreatingStrategy() {
        Faker faker = new Faker();
    }

    @Override
    public Player createPlayer() {
        return null;
    }



}
