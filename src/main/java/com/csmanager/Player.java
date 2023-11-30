package com.csmanager;

public class Player {
    private String name;
    private int experience;
    private int faceitRanking;

    public Player(String name, int experience, int faceitRanking) {
        this.name = name;
        this.experience = experience;
        this.faceitRanking = faceitRanking;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", faceitRanking=" + faceitRanking +
                '}';
    }
}
