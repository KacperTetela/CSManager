package com.csmanager.model.player.builder;

public class PrefabricatedPlayerBuilder {
    private String name;
    private double[][] roleTypeValues;

    public PrefabricatedPlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PrefabricatedPlayerBuilder roleTypeValues(double[][] roleTypeValues) {
        this.roleTypeValues = roleTypeValues;
        return this;
    }

    public Player build() {
        return new Player(name, roleTypeValues);
    }
}