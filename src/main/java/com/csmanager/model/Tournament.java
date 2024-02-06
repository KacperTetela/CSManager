package com.csmanager.model;

public class Tournament {
    private String name;
    private int prizepool;

    public Tournament(String name, int prizepool) {
        this.name = name;
        this.prizepool = prizepool;
    }

    @Override
    public String toString() {
        return "Tournament " +
                "name=" + name +
                " ,prizepool=" + prizepool + " \n";
    }
}
