package com.csmanager.model.player.builder;

public class PlayerBuilder {
    private String name;

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Player build() {
        return new Player(name);
    }
}