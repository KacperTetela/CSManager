package com.csmanager;

import java.util.Objects;

public class Player {
    private String name;
    private int experience;
    private int skillLevel;

    public Player(String name, int experience, int skillLevel) {
        this.name = name;
        this.experience = experience;
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", faceitRanking=" + skillLevel +
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

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }
}
