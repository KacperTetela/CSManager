package com.csmanager;

import java.util.Objects;

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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setFaceitRanking(int faceitRanking) {
        this.faceitRanking = faceitRanking;
    }
}
